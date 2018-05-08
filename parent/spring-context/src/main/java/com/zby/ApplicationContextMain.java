package com.zby;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zby.bean.CommonBean;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CommonBean commonBean = (CommonBean) applicationContext.getBean("commonBean");
		commonBean.sayHello();
		System.out.println(commonBean.getBeanA());

		// ǰ��ֻ�ܷ������ǰ�����ķ��������߿��Է����������������з���
		System.out.println(Arrays.asList(applicationContext.getClass().getDeclaredMethods()));
		System.out.println(Arrays.asList(applicationContext.getClass().getMethods()));
		TimeUnit.HOURS.sleep(1);
		applicationContext.getClass().getMethod("close").invoke(applicationContext);

		// ʹ��ClassPathXmlApplicationContextֱ�ӵ���close()����
		// applicationContext.close();
	}

}