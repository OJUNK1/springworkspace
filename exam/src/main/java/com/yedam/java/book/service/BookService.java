package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> getBookList();

	public BookVO getBookInfo(BookVO bookVO);

	public int insertBook(BookVO bookVO);
}
