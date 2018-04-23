package com.zby.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zby.bean.CommonBean;

public class InitialBeanMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-instance.xml");
		CommonBean commonBean1 = (CommonBean) applicationContext.getBean("commonBean1");
		commonBean1.sayHello();
		CommonBean commonBean2 = (CommonBean) applicationContext.getBean("commonBean2");
		commonBean2.sayHello();
		CommonBean commonBean3 = (CommonBean) applicationContext.getBean("commonBean3");
		commonBean3.sayHello();
		CommonBean commonBean4 = (CommonBean) applicationContext.getBean("commonBean4");
		commonBean4.sayHello();
		applicationContext.close();
	}

}