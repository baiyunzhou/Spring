package com.zby.annotation.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("annotationBeanA")
public class AnnotationBeanA {
	// @Autowired
	// ���ָ�������ƣ�ֻ�ᰴ�����Ʋ��ң������Ȱ����ƣ�������
	@Resource
	private AnnotationBeanB annotationBeanB;

	public void hello() {
		annotationBeanB.hello();
	}
}
