package com.zby.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Order(Ordered.LOWEST_PRECEDENCE)
public class CustomCondition implements Condition {
	/**
	 * 参数一：条件上下文，可以获取当前注册上下文用于辅助匹配 。
	 * 参数二：注解元数据，可以获取到使用@Conditional注解，并使用当前类作为条件的类的所有注解信息。
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		BeanDefinitionRegistry registry = context.getRegistry();
		Environment environment = context.getEnvironment();
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		System.out.println("registry:" + registry + ",environment:" + environment + ",beanFactory:" + beanFactory);
		System.out.println(metadata);
		return true;
	}

}
