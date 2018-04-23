package com.zby.factory;

import com.zby.bean.CommonBean;

public class InstanceFactory {

	public CommonBean getCommonBean() {
		return new CommonBean("instance factory");
	}
}
