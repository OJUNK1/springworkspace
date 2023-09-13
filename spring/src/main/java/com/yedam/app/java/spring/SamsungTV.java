package com.yedam.app.java.spring;

import org.springframework.stereotype.Component;

@Component("tv") // Annotation 기반 bean 등록 방법 !!!! @Component ★★★
public class SamsungTV implements TV {
	
	@Override
	public void on() {
		System.out.println("삼성 TV를 켰습니다");
	}
}
