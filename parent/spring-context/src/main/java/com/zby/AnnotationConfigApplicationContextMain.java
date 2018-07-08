package com.zby;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zby.bean.CommonBean;

@Configuration
public class AnnotationConfigApplicationContextMain {
	@Bean
	public CommonBean commonBean() {
		return new CommonBean("zby");
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AnnotationConfigApplicationContextMain.class);
		CommonBean commonBean = (CommonBean) applicationContext.getBean("commonBean");
		commonBean.sayHello();
		applicationContext.close();
	}

}
