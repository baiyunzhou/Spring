package com.zby;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zby.bean.CommonBean;

public class ClassPathXmlApplicationContextMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml" },
				true, null);
		CommonBean commonBean = (CommonBean) applicationContext.getBean("commonBean");
		commonBean.sayHello();
		System.out.println(commonBean.getBeanA());

		System.out.println(Arrays.asList(applicationContext.getClass().getDeclaredMethods()));
		System.out.println(Arrays.asList(applicationContext.getClass().getMethods()));
		String chMessage = applicationContext.getMessage("username_tip", new Object[] { "周白云" }, Locale.SIMPLIFIED_CHINESE);
		System.out.println(chMessage);
		String usMessage = applicationContext.getMessage("username_tip", new Object[] { "zhoubaiyun" }, Locale.US);
		System.out.println(usMessage);
		applicationContext.publishEvent(new Date());
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
		// applicationContext.close();
	}
}