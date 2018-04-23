package com.zby.factory;

import com.zby.bean.CommonBean;

public class StaticFactory {

	public static CommonBean getCommonBean() {
		return new CommonBean("static factory");
	}
}
