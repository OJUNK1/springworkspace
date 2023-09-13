package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUint4ClassRunner라는 클래스를 지정해주면 ApplicationContext를 만들고 관리하는 작업을 진행
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperTest {
	@Autowired
	EmpMapper empMapper;
			
	@Test
	public void getEmp() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId("100");
		
		EmpVO findVO = empMapper.getEmp(empVO);
		
		assertEquals(findVO.getLastName(), "King"); // 객체 a와b의 값이 같은지 확인 
	}
	
	
}
