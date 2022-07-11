package com.spring.core.session06;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

// JDBC Java 配置
@Configuration
// @ComponentScan 有兩種撰寫方式 1) and 2) are Same
// 1)
//@ComponentScan(basePackages = {"com.spring.core.session06"} )
// 2)
@ComponentScan // 預設會掃描 SpringJDBCConfig 類的所在位置
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true )
@EnableTransactionManagement
public class SpringJDBCConfig {
	@Autowired
	protected Environment env; // protected 好處是可以被繼承 
	
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource(); // 使用 c3p0 的 API
		try {
			// Basic
			ds.setDriverClass(env.getProperty("jdbc.driver")); // beacuse ds.setDriverClass will throw exemption, then we shall use try-catch
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUser(null);
			ds.setPassword(env.getProperty("jdbc.password"));
			// Options
			ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setInitialPoolSize(10);
			ds.setMaxIdleTime(1800);
			ds.setMaxStatements(100);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		} 	
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
		
}
	

