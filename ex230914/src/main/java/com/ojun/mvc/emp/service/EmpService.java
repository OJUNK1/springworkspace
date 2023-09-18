package com.ojun.mvc.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	// 전체 조회
	public List<EmpVO> getEmpAll();

	// 단건 조회
	public EmpVO getEmp(EmpVO empVO);

	// 등록
	public int insertEmp(EmpVO empVO);

	// 수정 - 급여 갱신
	public String updateEmpSal(int empId, int raise);

	// 수정 - 사원 정보
	public Map<String, String> updateEmp(EmpVO empVO);

	/* 삭제 mapper는 메소드 하나당 sql 구문 한 개. 따라서 매개 변수가 int employeeId.
	   리턴 값이 Map으로 ..? 
	   활용법 : ajax로 데이터를 돌려줄 때 주로 사용.
	*/
	public Map<String, Object> delete(List<Integer> list);
}
