package com.zby.config;

import org.springframework.validation.MessageCodesResolver;

public class MyMessageCodesResolver implements MessageCodesResolver {

	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName) {
		return null;
	}

	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class<?> fieldType) {
		return null;
	}

}
