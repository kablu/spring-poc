package com.spring.di;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.DefaultBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.lifecycle.AppConfig;
import com.spring.lifecycle.TestSpringBean;
import com.spring.spring.locator.VaccinateConfig;

@SpringBootApplication
@ComponentScan(basePackages="com.spring.*")
public class SpringDiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringDiApplication.class, args);
		TestSpringBean bean = run.getBean(TestSpringBean.class);
		
		AppConfig appConfig = run.getBean(AppConfig.class);
		
		DBBeanConfig dbConfig = run.getBean(DBBeanConfig.class);
		
		System.out.println(appConfig.testSpringBean());
	 
		//MongoBeanConfig mongoBeanConfig = run.getBean(MongoBeanConfig.class);
		 
		//MongoBean mb = run.getBean(MongoBean.class);
		
		if(dbConfig != null) {
			MongoBean mb = dbConfig.mongoBean();
			System.out.println("MongoUserName:" + mb.getUsername());
			System.out.println("Mongo Driver:" + mb.getDriver());
		} 

		PostgresBean postgresBean = appConfig.postgresBean();
		System.out.println("Postgres Bean User Name:" + postgresBean.getUsername());
		
		ModernaVaccine modernaVaccine = appConfig.modernaVaccine();
		
		System.out.println("moderna Vaccine dose:" + modernaVaccine.getNumOfDose());
		
		
		VaccinateConfig bean2 = run.getBean(VaccinateConfig.class);
		
		run.close();
		
		
	}

}
