package co.ojun.mvc.board.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@Value("${file.upload.path}") // 환경변수나, properties에 있는 값을 불러들일 때 @Value 사용
	private String uploadPath;

	@GetMapping("uploadForm")
	public void getUploadForm() {
	}

	@PostMapping("/uploadsAjax")
	@ResponseBody // 결과를 data로 돌려주고 싶을 때는 @ResponseBody, 페이지로 돌려주고 싶으면 안 써도 됨.
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) { //@RequestPart, tag에 multiple 붙이면 여러개가 넘어오기 때문에 배열로 받음.

		List<String> imageList = new ArrayList<>();

		for (MultipartFile uploadFile : uploadFiles) {
			
			if (uploadFile.getContentType().startsWith("image") == false) {
				System.err.println("this file is not image type");
				return null;
			}
			
			// 실제로 업로드 된 파일명을 가져오는 방법
			String originalName = uploadFile.getOriginalFilename(); // 사용자가 실제로 업로드한 파일 이름.
			String fileName = originalName.substring(originalName.lastIndexOf("//") + 1); // 경로로 넘어오기 때문에 순수한 파일명을 가져오기 위해 한번 짜름
			System.out.println("originalName : " + originalName);
			System.out.println("fileName : " + fileName);
			
			// 서버 내 (프로젝트 내 X) 별도의 폴더에, 업로드된 파일에 별도의 이름을 지정해서, 등록하는 방법. 날짜 폴더와 uuid 값을 통해 경로가 생성될 것.
			// 날짜와 관련된 폴더 생성 (UPLOAD 저장 공간에 현재 날짜를 기준으로 해서 폴더를 생성하는 것)
			String folderPath = makeFolder();
			// UUID ( 랜덤값. 사용자가 모두 '사과.jpg'로 올려도 우리는 이것을 구분해야 하기 때문에 랜덤값을 부여하는 것임)
			String uuid = UUID.randomUUID().toString();
			// 저장할 파일 이름 중간에 "_"를 이용하여 구분

			String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;

			String saveName = uploadPath + File.separator + uploadFileName; // uploadPath(UPLOAD 폴더) + uploadFileName;

			Path savePath = Paths.get(saveName); // 문자로 만들어놓은 saveName 경로를 기반으로 실제로 내부에 존재하는지 확인하는 것.
			// Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
			System.out.println("path : " + saveName);
			try {
				uploadFile.transferTo(savePath);
				// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
			} catch (IOException e) {
				e.printStackTrace();
			}
			// DB에 해당 경로 저장
			// 1) 사용자가 업로드할 때 사용한 파일명
			// 2) 실제 서버에 업로드할 때 사용한 경로
			imageList.add(setImagePath(uploadFileName));
		}

		return imageList;
	}

	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);
		File uploadPathFolder = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");
		if (uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}

	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}
}
