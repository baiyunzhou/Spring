package com.zby;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.zby.bean.CommonBean;

public class GenericXmlApplicationContextMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		CommonBean commonBean = (CommonBean) applicationContext.getBean("commonBean");
		commonBean.sayHello();
		System.out.println(commonBean.getBeanA());

		System.out.println(Arrays.asList(applicationContext.getClass().getDeclaredMethods()));
		System.out.println(Arrays.asList(applicationContext.getClass().getMethods()));
		applicationContext.getClass().getMethod("close").invoke(applicationContext);

		// applicationContext.close();
	}
}