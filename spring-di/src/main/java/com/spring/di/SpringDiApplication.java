package com.spring.di;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.lifecycle.AppConfig;
import com.spring.lifecycle.TestSpringBean;

@SpringBootApplication
@ComponentScan(basePackages="com.spring.lifecycle")
public class SpringDiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringDiApplication.class, args);
		TestSpringBean bean = run.getBean(TestSpringBean.class);
		AppConfig bean2 = run.getBean(AppConfig.class);
		
		System.out.println(bean2.testSpringBean());
		run.close();
		
		
	}

}
