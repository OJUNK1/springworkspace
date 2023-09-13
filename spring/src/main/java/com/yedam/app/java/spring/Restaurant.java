package com.yedam.app.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	@Autowired //  autowired 할 클래스가 bean으로 등록되어있지 않으면 작동하지 않음. 즉 chef가 bean 등록 되어야 함.
	Chef chef;

	public void open() {
		chef.cooking();
	}
}
