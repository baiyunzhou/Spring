package com.zby.autowire;

public class BeanA {
	private BeanB beanB;
	private BeanC beanC;

	public BeanA() {
		System.out.println("BeanA()");
	}

	public BeanA(BeanB beanB, BeanC beanC) {
		System.out.println("BeanA(BeanB beanB, BeanC beanC)");
		this.beanB = beanB;
		this.beanC = beanC;
	}

	public BeanB getBeanB() {
		return beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}

	public BeanC getBeanC() {
		return beanC;
	}

	public void setBeanC(BeanC beanC) {
		this.beanC = beanC;
	}

	@Override
	public String toString() {
		return "BeanA [beanB=" + beanB + ", beanC=" + beanC + "]";
	}

}
