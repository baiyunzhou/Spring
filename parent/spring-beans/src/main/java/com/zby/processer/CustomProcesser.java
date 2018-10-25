package com.zby.processer;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 
 * @author zhoubaiyun
 * @date 2018年10月19日
 * @Description Bean初始化过程中的处理器
 */
public class CustomProcesser implements BeanPostProcessor, InstantiationAwareBeanPostProcessor, SmartInstantiationAwareBeanPostProcessor,
		DestructionAwareBeanPostProcessor, MergedBeanDefinitionPostProcessor {
	private AtomicInteger step = new AtomicInteger(1);

	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		System.out.println("第" + step.getAndIncrement() + "步：");
		System.out.println(
				"-->开始执行MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName)");
		System.out.println("-->参数：" + beanDefinition + beanType + beanName);
		System.out.println("-->结果：无返回");
	}

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		System.out.println("第" + step.getAndIncrement() + "步：");
		System.out.println("-->开始执行DestructionAwareBeanPostProcessor.postProcessBeforeDestruction(Object bean, String beanName)");
		System.out.println("-->参数：" + bean + beanName);
		System.out.println("-->结果：无返回");
	}

	@Override
	public boolean requiresDestruction(Object bean) {
		return false;
	}

	@Override
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		return beanClass;
	}

	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		return null;
	}

	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return false;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}

}
