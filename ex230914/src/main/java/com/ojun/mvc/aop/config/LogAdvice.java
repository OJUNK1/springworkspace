package com.ojun.mvc.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect    // AOP와 관련된 설정을 가지고 있음을 알려주는 어노테이션
@Component // Bean 으로 등록
public class LogAdvice {
	// 포인트컷 : 조인포인트(비즈니스 로직과 관련된 모든 메소드) 중에서 Advice(공통 로직)가 적용 될 메소드
	@Pointcut("execution(* *..*ServiceImpl.*(..))")
	//@Pointcut("within(*..*ServiceImpl)")
	public void allPointCut() {
		
	}

	// 위빙 : 포인트컷 + Advice + 동작 시점
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
		    //AOP가 적용되는 메서드의 이름
		String signatureStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatureStr);
		
		// 비즈니스 메소드 실행 전 Advice 실행 (try)
		System.out.println("핵심 기능 전 실행 - 공통 기능 : " + System.currentTimeMillis());
		try {
			Object obj = joinPoint.proceed(); // 실제 비즈니스 메소드가 실행되는 코드.
			return obj; // 모든 return 타입을 수용해야 하기 때문에 Object로 return 받음.
		} finally {
			// 비즈니스 메소드 실행 후 Advice 실행 (finally)
			System.out.println("핵심 기능 후 실행 - 공통 기능 : " + System.currentTimeMillis());
		}
	}
}
