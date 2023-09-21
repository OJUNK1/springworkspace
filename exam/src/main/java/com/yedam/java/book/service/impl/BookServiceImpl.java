package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;

	@Override
	public List<BookVO> getBookList() {
		return bookMapper.selectAll();
	}

	@Override
	public BookVO getBookInfo(BookVO bookVO) {
		return bookMapper.selectOne(bookVO);
	}

	@Override
	public int insertBook(BookVO bookVO) {
		int result = bookMapper.insert(bookVO);

		if (result == 1) {
			return bookVO.getBookNo();
		} else {
			return -1;
		}
	}

}
