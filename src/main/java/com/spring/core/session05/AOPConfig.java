package com.spring.core.session05;
import org.springframework.context.annotation.ComponentScan; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 此為 Java 配置檔
//@ComponentScan(basePackages = {"com.spring.core.session04", "com.spring.core.session03"}) // 啟用元件掃描(指定掃瞄路徑)
@ComponentScan // 啟用元件掃描(掃瞄有 @ 註解的元件, 目的是交由 String 來管理)
@EnableAspectJAutoProxy // 自動生成代理物件
public class AOPConfig {
	

}
