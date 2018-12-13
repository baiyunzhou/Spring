package com.zby.bean;

import org.springframework.context.Lifecycle;

public class CommonBean implements Lifecycle {
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

	@Override
	public void start() {
		System.out.println("启动");

	}

	@Override
	public void stop() {
		System.out.println("停止");

	}

	@Override
	public boolean isRunning() {
		return false;
	}

}
