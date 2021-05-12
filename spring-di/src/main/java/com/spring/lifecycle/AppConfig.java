package com.spring.lifecycle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.spring.di.CovidScheild;
import com.spring.di.CovidScheildCondition;
import com.spring.di.DBBeanConfig;
import com.spring.di.ModernaVaccine;
import com.spring.di.ModernaVaccineCondition;
import com.spring.di.MongoBean;
import com.spring.di.MongoDBPresenceConditionCheck;
import com.spring.di.PostgresBean;
import com.spring.spring.locator.CoVaxin;
import com.spring.spring.locator.Moderna;

@Configuration
@ComponentScan(basePackages="com.spring.lifecycle")
@PropertySource(value="classpath:test.properties", ignoreResourceNotFound=true)
public class AppConfig {

	@Bean(name = "ts")
	TestSpringBeanPostProcessor testSpringBeanPostProcessor() {
		return new TestSpringBeanPostProcessor();
	}
	
	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod", name = "testSprBean")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TestSpringBean testSpringBean() {
		return new TestSpringBean();
	}
	
	@Bean
	@Scope("prototype")
	@Primary
	public TestSpringBean testSpringBean1() {
		return new TestSpringBean();
	}
	
	
	
	@Bean
	@Conditional(MongoDBPresenceConditionCheck.class)
	public PostgresBean postgresBean() {
		System.out.println("postgresBean is creating..");
		PostgresBean mb = new PostgresBean();
		mb.setDriver("Postgres Driver");
		mb.setUsername("Postgres User");
		mb.setPassword("Postgres Password");
		mb.setUrl("Postgres Url");
		
		return mb;
		
	}
	
	/*
	 * @Bean
	 * 
	 * @Conditional(MongoBean.class) public MongoBean mongoBean() {
	 * System.out.println("Mongo bean is creating.."); MongoBean mb = new
	 * MongoBean(); mb.setDriver("Mongo Driver"); mb.setUsername("Mongo User");
	 * mb.setPassword("Mongo Password"); mb.setUrl("Mongo Url");
	 * 
	 * return mb;
	 * 
	 * }
	 */
	
	/*
	 * @Bean
	 * 
	 * @Conditional(MongoDBPresenceConditionCheck.class) public MongoBean
	 * mongoBean() { System.out.println("Bean is creating using MongoBeanConfig..");
	 * MongoBean mb = new MongoBean(); mb.setDriver("Mongo Driver");
	 * mb.setUsername("MongoUser"); mb.setPassword("MongoPassword");
	 * mb.setUrl("MongoUrl"); return mb; }
	 */
	
	@Bean
	@Conditional(ModernaVaccineCondition.class)
	public ModernaVaccine modernaVaccine() {
		System.out.println("@@inside modernaVaccine..");
		return new ModernaVaccine(2);
	}
	 
	@Bean
	@Conditional(CovidScheildCondition.class)
	public CovidScheild covidScheild() {
		System.out.println("@@inside CovidScheild..");
		return new CovidScheild(2);
	}
	

	@Bean
	public CoVaxin coVaxin() {
		return new CoVaxin();
	}
	@Bean
	public Moderna moderna() {
		return new Moderna();
	}
	
	@Bean("vaccinationFactory")
	public ServiceLocatorFactoryBean vaccinationFactory() {
		ServiceLocatorFactoryBean sb = new ServiceLocatorFactoryBean();
		sb.setServiceLocatorInterface(ServiceLocatorFactoryBean.class);
		return sb;
	}
}
