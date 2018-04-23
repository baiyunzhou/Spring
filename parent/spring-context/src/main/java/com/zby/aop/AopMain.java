package com.zby.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-aspectj.xml");
		OriginBean originBean = (OriginBean) applicationContext.getBean("originBean");
		originBean.execute();
		applicationContext.close();
	}

}
