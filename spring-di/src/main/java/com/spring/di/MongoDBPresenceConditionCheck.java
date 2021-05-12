package com.spring.di;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDBPresenceConditionCheck implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		MongoBean mongoBean = null;
		try {
			mongoBean = (MongoBean)context.getBeanFactory().getBean("mongoBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mongoBean != null;
	}

}
