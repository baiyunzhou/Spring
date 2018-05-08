package com.zby.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println(importingClassMetadata);
		return new String[] { "com.zby.bean.CustomBean" };
	}

}
