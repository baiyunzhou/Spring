package com.zby.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.zby.annotation.bean.AnnotationBeanA;

@ComponentScan(basePackages = "com.zby.annotation.bean")
public class AnnotationApplicationContextMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AnnotationApplicationContextMain.class);
		AnnotationBeanA annotationBeanA = (AnnotationBeanA) applicationContext.getBean("annotationBeanA");
		annotationBeanA.hello();
		applicationContext.close();
	}

}
