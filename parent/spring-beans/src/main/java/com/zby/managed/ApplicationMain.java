package com.zby.managed;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class ApplicationMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ManagedBean managedBean = beanFactory.getBean(ManagedBean.class);
		System.out.println(managedBean);
	}

}
