package com.zby.bean;

public class BuilderMain {

	public static void main(String[] args) {
		CommonBean commonBean = CommonBean.builder().userName("hello").build();
		System.out.println(commonBean);
	}

}
