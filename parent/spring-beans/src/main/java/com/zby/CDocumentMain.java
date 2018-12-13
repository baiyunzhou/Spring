package com.zby;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/**
 * 
 * @author zby
 * @date 2018��4��21��
 * @description spring��ȡXML��ת��ΪDocument����
 */
public class CDocumentMain {

	public static void main(String[] args) throws Exception {
		// everytime use method resource.getInputSteam(),it return a new inputstream
		Resource resource = new ClassPathResource("applicationContext.xml");
		InputStream inputStream = resource.getInputStream();
		// ��org.xml.sax.InputSource��
		InputSource inputSource = new InputSource(inputStream);

		DocumentLoader documentLoader = new DefaultDocumentLoader();

		// ��org.xml.sax.EntityResolver��
		EntityResolver entityResolver = new ResourceEntityResolver(new DefaultResourceLoader());
		Log logger = LogFactory.getLog(CDocumentMain.class);
		// ��org.xml.sax.ErrorHandler��
		ErrorHandler errorHandler = new SimpleSaxErrorHandler(logger);

		XmlValidationModeDetector validationModeDetector = new XmlValidationModeDetector();
		// warn,detector will close the inputStream��so must give it a new one
		int validationMode = validationModeDetector.detectValidationMode(resource.getInputStream());
		if (validationMode != XmlValidationModeDetector.VALIDATION_AUTO) {
			validationMode = XmlValidationModeDetector.VALIDATION_XSD;
		}
		boolean namespaceAware = false;

		Document document = documentLoader.loadDocument(inputSource, entityResolver, errorHandler, validationMode, namespaceAware);
		System.out.println(document);
	}

}
