package com.zby.collection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjectMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-collection.xml");
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
		applicationContext.close();
	}

}
