package com.zby.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomDeferredImportSelector implements DeferredImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return null;
	}

}
