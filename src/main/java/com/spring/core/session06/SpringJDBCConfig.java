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
@Configuration  // 表示此類是一個配置檔

//@ComponentScan(basePackages = {"com.spring.core.session06"})
@ComponentScan // 預設會掃描 SpringJDBCConfig 類的所在位置，與上面的功能一致，只需擇一
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true)
@EnableTransactionManagement
public class SpringJDBCConfig {
	@Autowired
	protected Environment env; // protected 好處是可以被繼承 
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource(); // 使用 c3p0 的 API
		try {
			// Basic
			ds.setDriverClass(env.getProperty("jdbc.driver")); // beacuse ds.setDriverClass will throw exception, then  shall use try-catch
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUser(env.getProperty("jdbc.username"));
			ds.setPassword(env.getProperty("jdbc.password"));
			// Options
			ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setInitialPoolSize(10);
			ds.setMaxIdleTime(1800);
			ds.setMaxStatements(100);
			
		} catch (Exception e) {
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
	

