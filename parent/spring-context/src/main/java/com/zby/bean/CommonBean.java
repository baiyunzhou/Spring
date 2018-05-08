package com.zby.bean;

public class CommonBean {
	private String userName;
	// @Autowired
	private BeanA beanA;

	public BeanA getBeanA() {
		return beanA;
	}

	public void setBeanA(BeanA beanA) {
		this.beanA = beanA;
	}

	public CommonBean() {
		System.out.println("invoke CommonBean()");
	}

	public CommonBean(String userName) {
		System.out.println("invoke CommonBean(String userName)");
		this.userName = userName;
	}

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
