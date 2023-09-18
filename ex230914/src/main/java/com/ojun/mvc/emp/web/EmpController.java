package com.ojun.mvc.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojun.mvc.emp.mapper.EmpMapper;
import com.ojun.mvc.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpMapper empMapper;

	// get : 조회, 빈 페이지 요청 ( 보안상 큰 문제가 되지 않는 경우 )
	// 그외(post, delete, put) : 등록, 수정, 삭제

	// @RequestMapping(value="empForm", method=RequestMethod.GET) 이것보다
	// @Get,putMapping 등을 많이 씀.
	@GetMapping("empForm")
	public void getEmpInfoForm() {
	}

	// 위에 꺼랑 같은 의미. 커맨드 객체를 통해 data를 받는 경우, 매개 변수에 어떠한 어노테이션도 붙지 않는다.
	// 내가 무언가 돌려주는 데이터가 있을 때, model 사용
	// 커맨드 객체 사용했음.
	@GetMapping("getEmp")
	public String getEmpData(EmpVO empVO, Model model) {
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empForm";
	}

	// @RequestParam은 기본적으로 필수값임. 따라서 값이 들어오지 않았을 때 오류가 발생함. 이에 대한 처리를 해 줘야 한다.
	// defaultValue, required, value 등.. 설정 가능! ppt-5(p.26)
	// name 속성 = "eId", http://localhost/mvc/getEmpData?eId=206
	@GetMapping("getEmpData")
	public String getEmpData(@RequestParam(defaultValue = "100", name = "eId", required = true) Integer employeeId,
			Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);

		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empForm";
	}

	// @PathVariable 경로에 있는 값을 불러 들임..
	@GetMapping("emp/{id}")
	public String getEmpData2(@PathVariable(name = "id") Integer employeeId, Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);

		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empForm";
	}

	@PostMapping("empInfoInsert")
	public String empInfoInsert(@RequestBody EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println("결과 : " + empVO.getEmployeeId());
		return "empForm";
	}
}
