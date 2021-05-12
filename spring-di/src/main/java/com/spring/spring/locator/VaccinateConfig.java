package com.spring.spring.locator;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.spring.spring.locator")
public class VaccinateConfig {
	/*
	 * @Bean("prototype") public CoVaxin coVaxin() { return new CoVaxin(); }
	 * 
	 * @Bean("prototype") public Moderna moderna() { return new Moderna(); }
	 * 
	 * @Bean("vaccinationFactory") public ServiceLocatorFactoryBean
	 * serviceLocatorFactoryBean() { ServiceLocatorFactoryBean sb = new
	 * ServiceLocatorFactoryBean();
	 * sb.setServiceLocatorInterface(ServiceLocatorFactoryBean.class); return sb; }
	 */
}
