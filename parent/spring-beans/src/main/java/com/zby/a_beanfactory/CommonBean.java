package com.zby.a_beanfactory;

public class CommonBean {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void sayHello() {
		System.out.println("Hello," + userName + "!");
	}

	public void init() {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}
}
