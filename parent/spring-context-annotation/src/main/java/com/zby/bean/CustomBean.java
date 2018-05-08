package com.zby.bean;

import java.util.Date;

public class CustomBean {
	private String name;
	private Integer age;
	private Date birthday;

	public CustomBean() {
	}

	public CustomBean(String name, Integer age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "CommonBean [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}

}
