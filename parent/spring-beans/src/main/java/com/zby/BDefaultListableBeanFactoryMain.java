package com.zby;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zby.bean.CommonBean;

/**
 * 
 * @author zby
 * @date 2018��4��21��
 * @description
 */
public class BDefaultListableBeanFactoryMain {

	public static void main(String[] args) {
		// 1.load bean metadata from XML configuration in classpath
		Resource resource = new ClassPathResource("applicationContext.xml");
		// 2.create BeanFactory with DefaultListableBeanFactory instance
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 3.create BeanDefinitionReader with XmlBeanDefinitionReader instance
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		// 4.use BeanDefinitionReader to load BeanDefinitions
		xmlBeanDefinitionReader.loadBeanDefinitions(resource);
		// 5.retrieve bean from BeanFactory
		CommonBean commonBean = (CommonBean) defaultListableBeanFactory.getBean("commonBean");
		// 6.use bean get from BeanFactory
		commonBean.sayHello();

	}

}
