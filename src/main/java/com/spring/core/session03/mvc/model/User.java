package com.spring.core.session03.mvc.model;
import java.util.Arrays; 
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
/*
 * 如果在 applicationContext.xml 配置 <context:component-scan base-package="com.spring.core.session03.mvc" />
 * 類的配置 @Controller /  @Component / @Service / @Repository 都可
 */
@Component  
@PropertySource("classpath:user.properties")
public class User {
	
	// @Value(value = "John")
	@Value("${user.username}")
	private String username; // 姓名
	
	//  @Value(value = "18")
	@Value("${user.age}")
	private Integer age; // 年齡
	
	// @Value(value = "#{${nickname: {'foo', 'bar'}}}") // 使用 Spring EL
	@Value("${user.nickname}")
	private String[] nickname; // 暱稱
	
	// @Value(value = "#{${subjects: {'Java', 'Math'}}}")
	@Value("${user.subjects}")
	private Set<String> subjects; // 專長科目
	
	//@Value(value = "#{${scores: {100, 90}}}")
	@Value("#{'${user.scores}'.split(',')}")
	private List<Integer> scores; // 成績
	
	
	//@Value(value = "#{${hobbies: {'h1': 'Car', 'h2': 'Game'}}}")
	@Value("#{${user.hobbies}}")
	private Map<String, String> hobbies; // 興趣

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<String, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", nickname=" + Arrays.toString(nickname) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
	
	
	
}