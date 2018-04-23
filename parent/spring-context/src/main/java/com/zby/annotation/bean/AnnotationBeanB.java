package com.zby.annotation.bean;

import org.springframework.stereotype.Component;

@Component("annotaitonBeanB")
public class AnnotationBeanB {
	public void hello() {
		System.out.println("AnnotationBeanB say:Hello,World!");
	}
}
