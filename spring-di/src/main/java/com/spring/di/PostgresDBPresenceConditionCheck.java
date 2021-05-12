package com.spring.di;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PostgresDBPresenceConditionCheck implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		MongoBeanConfig mongoBeanConfig = null;
		try {
			mongoBeanConfig = (MongoBeanConfig)context.getBeanFactory().getBean("postgresBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mongoBeanConfig != null;
	}

}
