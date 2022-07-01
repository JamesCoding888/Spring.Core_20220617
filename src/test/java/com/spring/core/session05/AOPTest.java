package com.spring.core.session05;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.core.session05.aop.MathCalc;
import com.spring.core.session05.aop.MathCalcImpl;

public class AOPTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		MathCalc calc = ctx.getBean("mathCalcImpl", MathCalcImpl.class);
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(20, 10));
	}
}


