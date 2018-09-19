package com.zby;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @author zby
 * @date 2018年4月21日
 * @description
 */
@SuppressWarnings("deprecation")
public class GYamlMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-yaml.xml"));
		Map<?, ?> map = (Map<?, ?>) beanFactory.getBean("yamlMap");
		System.out.println(map);
		Properties prop = (Properties) beanFactory.getBean("yamlProperties");
		System.out.println(prop.keySet());
	}

}
