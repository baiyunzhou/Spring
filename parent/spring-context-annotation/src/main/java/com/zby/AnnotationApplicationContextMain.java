package com.zby;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.zby.bean.CommonBean;
import com.zby.bean.CustomBean;
import com.zby.condition.CustomCondition;
import com.zby.condition.CustomConfigurationCondition;
import com.zby.selector.CustomDeferredImportSelector;
import com.zby.selector.CustomImportBeanDefinitionRegistrar;
import com.zby.selector.CustomSelector;

@Configuration
@Conditional(value = { CustomCondition.class, CustomConfigurationCondition.class })

@PropertySource(value = "prop1.properties")
@PropertySources({ @PropertySource(value = "prop2.properties"), @PropertySource(value = "prop3.properties") })

@ComponentScan(basePackages = { "com.zby.dao" })
@ComponentScans(value = { @ComponentScan(basePackages = { "com.zby.dao" }), @ComponentScan(basePackages = { "com.zby.service" }) })

@Import({ CustomSelector.class, CustomDeferredImportSelector.class, CustomImportBeanDefinitionRegistrar.class })

@ImportResource({ "application.xml" })
public class AnnotationApplicationContextMain {

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