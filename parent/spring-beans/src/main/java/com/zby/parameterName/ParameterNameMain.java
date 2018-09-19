package com.zby.parameterName;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

public class ParameterNameMain {

	public static void main(String[] args) {
		// ParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
		ParameterNameDiscoverer discoverer = new StandardReflectionParameterNameDiscoverer();
		Method[] methods = ParameterNameMain.class.getMethods();
		for (Method method : methods) {
			String[] names = discoverer.getParameterNames(method);
			System.out.print(method + "--->");
			if (null != names) {
				System.out.print(Arrays.asList(names));
			}
			System.out.println();
		}

	}

}
