package com.spring.lifecycle;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ComponentScan(basePackages="com.spring.lifecycle")
public class AppConfig {

	@Bean(name = "ts")
	TestSpringBeanPostProcessor testSpringBeanPostProcessor() {
		return new TestSpringBeanPostProcessor();
	}
	
	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod", name = "testSprBean")
	//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TestSpringBean testSpringBean() {
		return new TestSpringBean();
	}
	 
}
