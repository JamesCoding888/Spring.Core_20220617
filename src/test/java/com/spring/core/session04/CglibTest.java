package com.spring.core.session04;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import com.spring.core.session04.cglib.Hello;
import com.spring.core.session04.cglib.MyMethodInterceptor;

public class CglibTest {
	@Test
	public void test() {
		// 使用 cglib
		// 1. 增強器
		Enhancer enhancer = new Enhancer();
		// 2. 要增強的對象
		enhancer.setSuperclass(Hello.class);
		// 3. 設置方法攔截器
		enhancer.setCallback(new MyMethodInterceptor());
		// 4. 運行
		Hello hello = (Hello)enhancer.create();
		System.out.println(hello.sayHello("Mary"));
		
	}
}
