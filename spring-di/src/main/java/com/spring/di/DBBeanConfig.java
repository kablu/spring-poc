package com.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBBeanConfig {

	@Bean(name = "mongoBean")
	@Conditional(MongoBean.class)
	public MongoBean mongoBean() {
		System.out.println("Bean is creating..");
		MongoBean mb = new MongoBean();
		mb.setDriver("Mongo Driver");
		mb.setUsername("MongoUser");
		mb.setPassword("MongoPassword");
		mb.setUrl("MongoUrl");
		return mb;
	}

}
