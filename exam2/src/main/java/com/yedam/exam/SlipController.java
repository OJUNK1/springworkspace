package com.yedam.exam;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SlipController {
	
	private static final Logger logger = LoggerFactory.getLogger(SlipController.class);
	
	@Autowired
	SlipService slipService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 핸들러 
	
	@RequestMapping("/insertSlip")
	@ResponseBody
	public Map<String, Object> insertSlip(@RequestBody List<Slip> slip) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int total =	slip.size();
		List<String> str = slipService.insertSlip(slip);
	
		
		map.put("total", total);
		map.put("success", str.size());
		map.put("empList", str);
		 	
		return map;
	}
	
}
