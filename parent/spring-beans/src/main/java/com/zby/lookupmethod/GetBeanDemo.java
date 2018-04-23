package com.zby.lookupmethod;

public abstract class GetBeanDemo {

	public void hello() {
		getBean().hello();
	}

	abstract User getBean();

	abstract User get();
}
