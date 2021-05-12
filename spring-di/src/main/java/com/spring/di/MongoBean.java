package com.spring.di;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoBean implements Condition {

	private String driver;
	private String url;
	private String username;
	private String password;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Environment environment = context.getEnvironment();
		String dbProperty = environment.getProperty("dbType");
		System.out.println("dbProperty:" + dbProperty);
		if(dbProperty.equals("mongo")) {
			System.out.println("====Mongo DB===");
			return true;
		}else {
			//System.out.println("===Mongo DB====");
			return false;
		}
	}
	
	
}
