package com.zby;

import java.util.Arrays;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.zby.bean.CommonBean;
import com.zby.bean.CustomBean;
import com.zby.condition.CustomCondition;
import com.zby.selector.CustomSelector;

@Conditional(CustomCondition.class)
@Configuration
@Import(CustomSelector.class)

public class AnnotationApplicationContextMain {
	@Bean
	@Profile("prod")
	public CommonBean commonBean() {
		return new CommonBean("zby", 24, new Date());
	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AnnotationApplicationContextMain.class);
		System.out.println(":::::" + Arrays.toString(applicationContext.getBeanDefinitionNames()));
		CustomBean customBean = applicationContext.getBean(CustomBean.class);
		System.out.println(customBean);
		CommonBean commonBean = applicationContext.getBean(CommonBean.class);
		System.out.println(commonBean);

		applicationContext.close();
	}

}
// AnnotationConfigApplicationContext初始化同属初始化下面两个组件

// AnnotatedBeanDefinitionReader初始化时注册ConfigurationClassPostProcessor、AutowiredAnnotationBeanPostProcessor、
// RequiredAnnotationBeanPostProcessor、CommonAnnotationBeanPostProcessor、EventListenerMethodProcessor、DefaultEventListenerFactory

// ClassPathBeanDefinitionScanner默认扫描Component注解