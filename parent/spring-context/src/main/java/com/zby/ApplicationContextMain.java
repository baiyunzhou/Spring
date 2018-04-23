package com.zby;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zby.bean.CommonBean;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CommonBean commonBean = (CommonBean) applicationContext.getBean("commonBean");
		commonBean.sayHello();

		// 前者只能反射出当前声明的方法，后者可以反射出包括父类的所有方法
		System.out.println(Arrays.asList(applicationContext.getClass().getDeclaredMethods()));
		System.out.println(Arrays.asList(applicationContext.getClass().getMethods()));

		applicationContext.getClass().getMethod("close").invoke(applicationContext);

		// 使用ClassPathXmlApplicationContext直接调用close()方法
		// applicationContext.close();
	}

}