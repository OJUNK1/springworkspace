package com.yedam.java.rent.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.rent.service.RentService;
import com.yedam.java.rent.service.RentVO;

@Controller
public class RentController {

	@Autowired
	RentService rentService;
	
	@Autowired
	BookService bookService;
	

	@GetMapping("rentList")
	public String selectAll(Model model) {
		List<RentVO> list = rentService.getRentList();
		
		
		model.addAttribute("rents", list);
		System.out.println(list);
		return "rent/rentList";
	}

}
