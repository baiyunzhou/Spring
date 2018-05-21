package com.zby.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomConfigurationCondition implements ConfigurationCondition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.out.println(context);
		System.out.println(metadata);
		return true;
	}

	public ConfigurationPhase getConfigurationPhase() {

		return ConfigurationPhase.PARSE_CONFIGURATION;
	}

}
