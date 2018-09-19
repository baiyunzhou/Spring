package com.zby.parameterName;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Conventions;

public class ConventionsMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = ConventionsMain.class.getMethod("say");
		String nameForReturnType = Conventions.getVariableNameForReturnType(method, List.class, new ArrayList<>());
		System.out.println(nameForReturnType);

	}

	public static List<String> say() {
		return new ArrayList<>();
	}
}
