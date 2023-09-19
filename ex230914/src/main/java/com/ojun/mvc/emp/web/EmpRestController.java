package com.ojun.mvc.emp.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojun.mvc.emp.service.EmpService;
import com.ojun.mvc.emp.service.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	EmpService empService;

	// 전체 조회 : get + uri
	@GetMapping("emps")
	public List<EmpVO> getEmpAllList() {
		return empService.getEmpAll();
	}

	// 단건 조회 : get + uri + @PathVariable
	@GetMapping("emps/{empId}")
	public EmpVO getEmpInfo(@PathVariable int empId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(empId);
		
		return empService.getEmp(empVO);
	}
	// 등록 : post + uri + @RequestBody
	@PostMapping("emps")
	public int insertEmpInfo(@RequestBody EmpVO empVO) {
		return empService.insertEmp(empVO);
	}
	// 수정 : put + uri + @PathVariable, @RequestBody
	@PutMapping("emps/{empId}")
	public Map<String, String> updateEmpInfo(@PathVariable int empId, @RequestBody EmpVO empVO) {
			empVO.setEmployeeId(empId);
			return empService.updateEmp(empVO);
	}
	// 삭제 : delete + uri + @PathVariable
	@DeleteMapping("emps/{empId}")
	public Map<String, Object> deleteEmpInfo(@PathVariable int empId) {
		List<Integer> list = new ArrayList<>();
		list.add(empId);
		return empService.deleteEmp(list);
	}
	
}
