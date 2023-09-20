package com.ojun.mvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ojun.mvc.emp.mapper.EmpMapper;
import com.ojun.mvc.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class EmpMapperTest {
	@Autowired
	EmpMapper empMapper;

	//@Test
	public void selectAllEmp() {
		// 전체 조회
		List<EmpVO> empList = empMapper.selectEmpAllList(new EmpVO());
		assertNotNull(empList);
	}

	//@Test
	public void selectEmpInfo() {
		// 단건 조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}

	//@Test
	public void insertEmpInfo() {
		// 등록
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kim");
		empVO.setFirstName("Na-Na");
		empVO.setEmail("nnkim@google.com");
		empVO.setJobId("IT_PROG");
		
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0);
	}
	
	//@Test
	public void updateEmpSal() {
		// 급여 갱신
		int result = empMapper.updateEmpSal(100, 10);
		assertEquals(result, 1);
	}
	
	//@Test
	public void updateEmpInfo() {
		// 사원 정보 수정
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		
		empVO.setEmail("kang@naver.com");
		empVO.setSalary(6000);
		
		int result = empMapper.updateEmpInfo(empVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteEmpInfo() {
		int result = empMapper.deleteEmpInfo(207);
		assertEquals(result, 1);
	}
	
}
