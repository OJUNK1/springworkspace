package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("bookList")
	public String selectAll(Model model) {
		List<BookVO> list = bookService.getBookList();

		model.addAttribute("books", list);
		return "book/bookList";
	}

	@GetMapping("bookInfo")
	public String selectOne(BookVO bookVO, Model model) {
		BookVO vo = bookService.getBookInfo(bookVO);

		model.addAttribute("books", vo);
		return "book/bookInfo";
	}

	@GetMapping("bookInsert")
	public String insertForm(BookVO bookVO, Model model) {
		List<BookVO> vo = bookService.getBookList();
		int lastIdx = vo.size() - 1;

		BookVO lastBook = vo.get(lastIdx);

		int lastBookNo = lastBook.getBookNo() + 1;

		bookVO.setBookNo(lastBookNo);
		model.addAttribute("bookNo", lastBookNo);

		return "book/bookInsert";
	}

	@PostMapping("bookInsert")
	public String insert(BookVO bookVO, RedirectAttributes attributes) {
		bookService.insertBook(bookVO);
		
		return "redirect:bookList";
	}
}
