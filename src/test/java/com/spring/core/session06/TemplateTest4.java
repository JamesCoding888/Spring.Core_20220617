package com.spring.core.session06;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.core.session06.template.EmpDao;

public class TemplateTest4 {
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		// no problem
		/*
		 int[] rowcount = empDao.addTwoTx("Z01", 20, "Z02", 21);
		 int[] rowcount = empDao.addTwoTx("Z06", 20, "Z05", 21);
		*/
		// bug - rollback
//		/*
		int[] rowcount = empDao.addTwoTx("Z03", 20, "Z01", 21);
//		*/
		
		System.out.println(Arrays.toString(rowcount));
		
	}
}