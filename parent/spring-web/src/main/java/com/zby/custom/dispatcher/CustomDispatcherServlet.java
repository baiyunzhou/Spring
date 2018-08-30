package com.zby.custom.dispatcher;

import org.springframework.web.servlet.DispatcherServlet;

@SuppressWarnings("serial")
public class CustomDispatcherServlet extends DispatcherServlet {

	private static final String REQUIRED_CONFIG_LOCATION = "contextConfigLocation";

	public CustomDispatcherServlet() {
		// 必须手动指定springmvc配置文件路径
		addRequiredProperty(REQUIRED_CONFIG_LOCATION);
	}

}
