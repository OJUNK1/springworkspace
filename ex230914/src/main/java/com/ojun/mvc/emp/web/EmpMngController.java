package com.ojun.mvc.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ojun.mvc.emp.service.EmpService;
import com.ojun.mvc.emp.service.EmpVO;

@Controller
public class EmpMngController {

	@Autowired
	EmpService empService;

	// 조회(데이터, 일반페이지) -> GET
	// 등록, 수정, 삭제 -> POST (예외: 단건삭제 - GET)

	// 전체 조회
	@GetMapping("empList")
	public String getEmpAllList(Model model) {
		// 조회한 결과를 담아야하기 때문에 model이 반드시 필요, 그리고 데이터를 뿌려줄 페이지가 필요
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";
	}

	// 단건 조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}

	// 등록 - Form ( 입력을 받기 위한 Form 필요 )
	@GetMapping("empInsert")
	public String empInsertForm() {

		return "emp/empInsert";
	}

	// 등록 - Process (실제 기능을 처리) 등록을 수행한 후 전체 목록으로 돌아가기 위해서 Redirect !!
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes attr) {
		int empId = empService.insertEmp(empVO);

		String result = null;
		if (empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		} else {
			result = "정상적으로 등록되었습니다. \n 등록된 사원의 번호는 " + empId + " 입니다.";
		}
		attr.addAttribute("type", "insert"); // addAttribute는 경로에 값이 붙음. return "redirect:empList?type=insert"; 와 같은 의미
		attr.addFlashAttribute("result", result); // result 값은 controller를 거쳐서도 살아서, empList.jsp로 가 줘야 함.
		return "redirect:empList"; // redirect는 jsp를 부를 수 없고, controller를 호출하는 것이다. insert 후 결과가 반영된 전체 목록을 조회하기
									// 위해서 redirect를 통해 empList controller를 부르는 것이다. return "emp/empList" 랑은 다름.
									// 페이지가 중요한 게 아니다.
	}
	// 수정 : 1) 단건조회 -> 2) 수정

	// 수정 - Form
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmp(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empUpdate";
	}

	// 수정 - Process : ajax 처리 => 필수 어노테이션은 @ResponseBody !! @RequestBody는 필수 어노테이션은
	// 아니다. json을 쓴다고 하면 ajax가 필수, 그러나 ajax 입장에서는 json data 필수 x 다른 방식으로도 데이터 전달 가능함.
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}

	// 삭제 - 단건 삭제

	// 삭제 - 선택 삭제(동시삭제)

}
