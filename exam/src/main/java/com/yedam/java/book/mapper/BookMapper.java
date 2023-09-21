package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	// 전체 조회
	public List<BookVO> selectAll();

	// 단건 조회
	public BookVO selectOne(BookVO bookVO);

	// 등록
	public int insert(BookVO bookVO);

}
