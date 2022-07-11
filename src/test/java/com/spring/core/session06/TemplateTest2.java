package com.spring.core.session06;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.template.EmpDao;

public class TemplateTest2 {
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		// 測試單筆新增 I
		// int rowcount_I = empDao.addOne1String("test1",18);
		// System.out.println(rowcount_I);
		
		// 測試單筆新增 II
		// int rowcount_II = empDao.addOne2("test2",19);
		// System.out.println(rowcount_II);
		
	
		// 測試批次新增 I
		/*
		List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[] {"jo", 20});
		rows.add(new Object[] {"James", 30});
		rows.add(new Object[] {"Mary", 40});
		int [] rowcounts = empDao.batchAdd1(rows);
		System.out.println(Arrays.toString(rowcounts));
		 */
		
		// 測試批次新增 II
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("Rose", 25));
		emps.add(new Emp("Jack", 18));
		int[] rowcounts = empDao.batchAdd2(emps);
		System.out.println(Arrays.toString(rowcounts));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}