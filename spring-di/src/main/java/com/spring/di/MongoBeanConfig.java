package com.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.spring.di")
@PropertySource(value="classpath:test.properties", ignoreResourceNotFound=true)
public class MongoBeanConfig {

	/*
	 * @Bean(name = "MongoBeanUsingCondition")
	 * 
	 * @Conditional(MongoDBPresenceConditionCheck.class) public MongoBean
	 * MongoBeanUsingCondition() {
	 * System.out.println("Bean is creating using MongoBeanConfig.."); MongoBean mb
	 * = new MongoBean(); mb.setDriver("Mongo Driver"); mb.setUsername("MongoUser");
	 * mb.setPassword("MongoPassword"); mb.setUrl("MongoUrl"); return mb; }
	 */
}
