package com.zby;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.zby.bean.CommonBean;
import com.zby.bean.CustomBean;
import com.zby.selector.CustomSelector;

@Configuration
@Import(CustomSelector.class)
public class AnnotationApplicationContextMain {
	@Bean
	public CommonBean commonBean() {
		return new CommonBean("zby", 24, new Date());
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AnnotationApplicationContextMain.class);
		CommonBean commonBean = applicationContext.getBean(CommonBean.class);
		System.out.println(commonBean);
		CustomBean customBean = applicationContext.getBean(CustomBean.class);
		System.out.println(customBean);
		applicationContext.close();
	}

}
