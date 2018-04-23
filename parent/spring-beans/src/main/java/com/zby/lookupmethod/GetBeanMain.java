package com.zby.lookupmethod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class GetBeanMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-lookupmethod.xml"));
		GetBeanDemo getBeanDemo = (GetBeanDemo) beanFactory.getBean("getBeanDemo");
		System.out.println(getBeanDemo);
		getBeanDemo.hello();
		// getBeanDemo.get();
	}

}
