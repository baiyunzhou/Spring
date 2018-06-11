package com.zby;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.zby.condition.CustomCondition;
import com.zby.condition.CustomConfigurationCondition;

//register-START
@Configuration("mainBean")
@Conditional(value = { CustomCondition.class, CustomConfigurationCondition.class })
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.DEFAULT)

@Lazy(false)
@Primary()
@DependsOn()
@Role(BeanDefinition.ROLE_APPLICATION)
@Description("This is the startup class.")
// regiter-END

// @PropertySource(value = "prop1.properties")
// @PropertySources({ @PropertySource(value = "prop2.properties"), @PropertySource(value = "prop3.properties") })

@ComponentScan(basePackages = { "com.zby.dao" })
@ComponentScans(value = { @ComponentScan(basePackages = { "com.zby.dao" }), @ComponentScan(basePackages = { "com.zby.service" }) })

// @Import({ CustomSelector.class, CustomDeferredImportSelector.class, CustomImportBeanDefinitionRegistrar.class })

// @ImportResource({ "application.xml" })
public class AnnotationApplicationContextMain {
	@Resource(name = "systemProperties")
	private Map<String, String> systemProperties;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AnnotationApplicationContextMain.class);
		System.out.println(":::::" + Arrays.toString(applicationContext.getBeanDefinitionNames()));
		// CustomBean customBean = applicationContext.getBean(CustomBean.class);
		// System.out.println(customBean);
		// CommonBean commonBean = applicationContext.getBean(CommonBean.class);
		// System.out.println(commonBean);
		AnnotationApplicationContextMain annotationApplicationContextMain = applicationContext
				.getBean(AnnotationApplicationContextMain.class);
		System.out.println("systemProperties:---------" + annotationApplicationContextMain.systemProperties);
		applicationContext.close();
	}
}
// AnnotationConfigApplicationContext初始化同属初始化下面两个组件

// AnnotatedBeanDefinitionReader初始化时注册ConfigurationClassPostProcessor、AutowiredAnnotationBeanPostProcessor、
// RequiredAnnotationBeanPostProcessor、CommonAnnotationBeanPostProcessor、EventListenerMethodProcessor、DefaultEventListenerFactory

// ClassPathBeanDefinitionScanner默认扫描Component注解