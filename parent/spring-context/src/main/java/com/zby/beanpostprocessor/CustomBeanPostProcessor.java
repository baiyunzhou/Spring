package com.zby.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("enter CustomBeanPostProcessor.postProcessBeforeInitialization");
		System.out.println("bean=" + bean + ";beanName=" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("enter CustomBeanPostProcessor.postProcessAfterInitialization");
		System.out.println("bean=" + bean + ";beanName=" + beanName);
		return bean;
	}

}
