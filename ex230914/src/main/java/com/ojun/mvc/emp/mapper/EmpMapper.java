package com.ojun.mvc.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ojun.mvc.emp.service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectEmpAllList();

	// 단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);

	// 등록(DML 구문은 항상 정수값을 반환하므로 int)
	public int insertEmpInfo(EmpVO empVO);

	// 수정 - 급여를 정해진 비율로 인상,  매개 변수가 2개이상 경우 처리 방법..  @Param  
	/*
	 * ex.. 매개 변수 2개일 때 객체인 경우? public int updateEmpSal(@Param("empId") int
	 * employeeId, @Param("emp")EmpVO empVO);
	 * 
	 * -> mapper.xml 에서 <update id="updateEmpSal"> #{emp.employeeId} </update>
	 */
	public int updateEmpSal(@Param("empId") int employeeId, @Param("raise")int raise);

	// 수정 - 사원 정보 수정
	public int updateEmpInfo(EmpVO empVO);

	// 삭제
	public int deleteEmpInfo(int employeeId);
}
