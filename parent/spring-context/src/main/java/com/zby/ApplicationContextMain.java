package com.zby;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zby.bean.CommonBean;

public class ApplicationContextMain { 

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CommonBean commonBean=(CommonBean)applicationContext.getBean("commonBean");
		commonBean.sayHello();
		applicationContext.getClass().getDeclaredMethod("close").invoke(applicationContext);
	}

}
