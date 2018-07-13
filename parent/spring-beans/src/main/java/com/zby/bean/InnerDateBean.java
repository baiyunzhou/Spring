package com.zby.bean;

import java.util.Date;

public class InnerDateBean {
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InnerDateBean [date=" + date + "]";
	}

}
