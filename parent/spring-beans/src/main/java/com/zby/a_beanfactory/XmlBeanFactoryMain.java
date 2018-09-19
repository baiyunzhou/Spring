package com.zby.a_beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class XmlBeanFactoryMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml", XmlBeanFactoryMain.class));
		CommonBean commonBean = (CommonBean) beanFactory.getBean("commonBean");
		commonBean.sayHello();
		beanFactory.containsBean("commonBean");
	}

}
