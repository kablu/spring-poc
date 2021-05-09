package com.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestSpringBeanPostProcessor implements BeanPostProcessor{

	@Override
	  public Object postProcessBeforeInitialization(Object bean, String beanName)
	      throws BeansException {
	    if (bean instanceof TestSpringBean) {
	      System.out.println("--- postProcessBeforeInitialization executed ---");
	    }
	    return bean;
	  }

	  @Override
	  public Object postProcessAfterInitialization(Object bean, String beanName)
	      throws BeansException {
	    if (bean instanceof TestSpringBean) {
	      System.out.println("--- postProcessAfterInitialization executed ---");
	    }
	    return bean;
	  }
	
	
}
