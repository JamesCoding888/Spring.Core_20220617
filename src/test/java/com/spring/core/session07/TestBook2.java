package com.spring.core.session07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.core.session07.tx.controller.BookController;

public class TestBook2 {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean(BookController.class);
		try {
			bookController.buyBooks(1, 1, 2); // wid, bids...
		} catch (Exception e) {
			 System.out.println(e);
		}
	}
}