package com.yedam.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		// Spring 컨테이너 구동
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); 
		
		// 객체 요청
		Mail mail = (Mail) ctx.getBean("mail");
		
		mail.printMessage();
	}
}
