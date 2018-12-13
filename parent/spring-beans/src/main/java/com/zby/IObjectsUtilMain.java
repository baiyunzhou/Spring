package com.zby;

import org.springframework.util.ObjectUtils;

public class IObjectsUtilMain {

	public static void main(String[] args) {
		System.out.println(new Obj().id);
		System.out.println(new Obj().id);
		System.out.println(new Obj().id);
	}

	private static class Obj {
		public String id = ObjectUtils.identityToString(this);
	}
}
