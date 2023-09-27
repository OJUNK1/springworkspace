package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	// 전체 조회
	public List<EmpVO> getEmpList();
	// 단건 조회
	public EmpVO getEmpInfo(EmpVO empVO);
	// 등록
	public int insertEmpInfo(EmpVO empVO);
}
