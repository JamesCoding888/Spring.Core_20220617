package com.spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 觀眾: 切面程式
public class Audience {
	@Pointcut(value = "execution(* com.spring.core.session05.aop_lab.Performance.perform(..))")
	public void pt() {
		
	}
	@Before(value = "pt()")
	public void muteCellPhone() {
		System.out.println("觀眾-關掉手機");
	}
	@Before(value = "pt()")
	public void haveSeat() {
		System.out.println("觀眾-找到座位");
	}
	
	@After(value = "pt()")
	public void applause() {
		System.out.println("觀眾-拍手鼓掌");
	}
	
	@AfterThrowing(value = "pt()")
	public void exit() {
		System.out.println("觀眾-離開表演會場");
	}
	
	@AfterReturning(value = "pt()")
	public void demandRefund() {
		System.out.println("觀眾-退票離場");
	}
	
	
}
