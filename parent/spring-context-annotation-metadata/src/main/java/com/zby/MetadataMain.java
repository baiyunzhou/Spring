package com.zby;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

/**
 * 
 * @author zby
 *
 */
public class MetadataMain {

	public static void main(String[] args) throws Exception {
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
		MetadataReader metadataReader = metadataReaderFactory.getMetadataReader("com.zby.bean.AnnotationedBean");
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		System.out.println(classMetadata.getClassName());
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		System.out.println(annotationMetadata.hasAnnotation(Configuration.class.getName()));
		Map<String, Object> orderAttributes = annotationMetadata.getAnnotationAttributes(Order.class.getName());
		if (orderAttributes != null) {
			System.out.println(orderAttributes.get(AnnotationUtils.VALUE));
		}
	}

}
// CachingMetadataReaderFactory->SimpleMetadataReaderFactory->MetadataReaderFactory
// SimpleMetadataReader->MetadataReader:使用asm读取class文件
// AnnotationMetadataReadingVisitor->ClassMetadataReadingVisitor->ClassVisitor(ASM的类)