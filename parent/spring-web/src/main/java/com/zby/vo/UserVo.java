package com.zby.vo;

import com.zby.mvc.excel.Header;

public class UserVo {
	@Header(index = 0)
	private String id;
	@Header(index = 1)
	private String name;
	@Header(index = 2)
	private String birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
