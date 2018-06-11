package com.zby.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomConfigurationCondition implements ConfigurationCondition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.out.println(context);
		System.out.println(metadata);
		return true;
	}

	/**
	 * 这个bean加载的时机是在配置还是注册Bean的时候
	 */
	public ConfigurationPhase getConfigurationPhase() {
		// return ConfigurationPhase.REGISTER_BEAN;
		return ConfigurationPhase.PARSE_CONFIGURATION;
	}

}
