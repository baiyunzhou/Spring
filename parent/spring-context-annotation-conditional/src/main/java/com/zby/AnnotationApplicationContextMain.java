package com.zby;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zby.bean.DataSource;
import com.zby.condition.Dev;
import com.zby.condition.Prod;
import com.zby.condition.Qa;

@Configuration

public class AnnotationApplicationContextMain {
	@Bean
	@Dev
	public DataSource commonBeanDev() {
		return new DataSource("jdbc:mysql://localhost:3306/dev", "devusername", "devpassword");
	}

	@Bean
	@Prod
	public DataSource commonBeanProd() {
		return new DataSource("jdbc:mysql://localhost:3306/prod", "produsername", "prodpassword");
	}

	@Bean
	@Qa
	public DataSource commonBeanQa() {
		return new DataSource("jdbc:mysql://localhost:3306/qa", "qausername", "qapassword");
	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().addActiveProfile("prod");
		applicationContext.register(AnnotationApplicationContextMain.class);
		applicationContext.refresh();
		System.out.println(":::::" + Arrays.toString(applicationContext.getBeanDefinitionNames()));
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
		applicationContext.close();
	}

}
