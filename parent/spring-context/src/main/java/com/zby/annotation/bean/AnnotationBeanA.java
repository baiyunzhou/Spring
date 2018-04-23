package com.zby.annotation.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("annotationBeanA")
public class AnnotationBeanA {
	// @Autowired
	// 如果指定了名称，只会按照名称查找；否则先按名称，后按类型
	@Resource
	private AnnotationBeanB annotationBeanB;

	public void hello() {
		annotationBeanB.hello();
	}
}
