package com.zby.aop;

import org.springframework.stereotype.Component;

@Component("originBean")
public class OriginBean {

	public void execute() {
		System.out.println("execute");
	}
}
