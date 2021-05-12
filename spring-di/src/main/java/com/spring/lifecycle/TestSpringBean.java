package com.spring.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component(value = "tt")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestSpringBean implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware{

	private String message;

	  public void sendMessage(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return this.message;
	  }
	  
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("====afterPropertiesSet executed=====TestSpringBean");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("====destroy of disposable bean executed====TestSpringBean");
		
	}
	
	/**
	 * jsr 250
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println("===postConstruct jsr executed==== TestSpringBean");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("===preDestroy jsr executed==== TestSpringBean");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name created:" + name);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("===applicationContext created===" + applicationContext.getApplicationName());
		
	}
	
	public void initMethod() {
		System.out.println("custom initMethod called.TestSpringBean.");
	}
	
	public void destroyMethod() {
		System.out.println("custom destroyMethod called..TestSpringBean");
	}

}
