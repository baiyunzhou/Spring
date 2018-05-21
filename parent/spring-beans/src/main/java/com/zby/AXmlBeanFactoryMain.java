package com.zby;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.zby.bean.CommonBean;

/**
 * 
 * @author zby
 * @date 2018年4月21日
 * @description
 */
@SuppressWarnings("deprecation")
public class AXmlBeanFactoryMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		CommonBean commonBean = (CommonBean) beanFactory.getBean("commonBean");
		commonBean.sayHello();
	}

}
