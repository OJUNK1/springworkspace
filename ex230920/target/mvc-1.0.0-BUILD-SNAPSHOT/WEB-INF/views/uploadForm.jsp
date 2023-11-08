<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
</head>
<body>
	<!-- 	<form action="upload" method="post" enctype="multipart/form-data"> -->
	<div>
		<input type="file" name="uploadFile" multiple>
		<button class="uploadBtn">등록</button>
	</div>
	<!-- 	</form> -->

	<script>
		$('.uploadBtn').click(function() {
			var formData = new FormData(); //FormData 객체 생성 -> multimedia data 속성을 다룰 때 용이. FormData 클래스가 contentType에 대한 정보를 가지고 있음.
			var inputFile = $("input[type='file']");

			var files = inputFile[0].files;
			//files : 선택한 모든 파일을 나열하는 FileList 객체입니다.
			//multiple 특성을 지정하지 않닸다면 두 개 이상의 파일을 포함하지 않습니다.

			for (var i = 0; i < files.length; i++) {
				console.log(files[i]);
				formData.append("uploadFiles", files[i]);//키,값으로 append 
			}
			
// 			// 실제 업로드 Ajax
// 			/* 자바스크립트 : fetch */
// 			fetch('uploadsAjax', {
// 				method : 'post', // header에 contentType 설정하지 않아도, formData 객체에 정보를 들고있기 때문에 fetch가 그 정보를 읽어들여 통신함. 
// 				body : formData
// 			})
// 			.then(response => response.json())
// 			.then(data => console.log(data))
// 			.catch(err => console.log(err));	
			
			//jQuery.ajax
	        $.ajax({
	            url: 'uploadsAjax',	
	            type: 'POST',
	            processData: false,	//기본값은 true, ajax 통신을 통해 데이터를 전송할 때, 기본적으로 key와 value값을 Query String으로 변환해서 보냅니다.
	            contentType: false,	// multipart/form-data타입을 사용하기위해 false 로 지정합니다.
	            data: formData,               
	            success: function(result){
	                for(let image of result){
						   let path = '${pageContext.request.contextPath}/images/' + image;
						   let imgTag = $('<img/>').prop('src', path).css('width', '200px');
						   $('div').append(imgTag);
					   }
	            },
	            error: function(reject){	
	                console.log(reject);
	            }
	        }); 
		});		       
	</script>
</body>
</html>