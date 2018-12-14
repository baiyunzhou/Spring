package com.zby;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.core.MethodParameter;

public class MethodParameterMain {

	public void test(Map<String, String> param) {

	}

	public static void main(String[] args) throws Exception {
		Method method = MethodParameterMain.class.getDeclaredMethod("test", Map.class);
		MethodParameter methodParameter = new MethodParameter(method, 0);
		System.out.println(methodParameter.nestedIfOptional().getNestedParameterType());

	}

}
