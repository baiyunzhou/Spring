package com.zby.vo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.zby.mvc.excel.Header;

public class UserVo {
	@Header(index = 0)
	private Long id;
	@Header(index = 1)
	private String name;
	@Header(index = 2)
	@JSONField(format = "yyyy-HH-dd")
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
