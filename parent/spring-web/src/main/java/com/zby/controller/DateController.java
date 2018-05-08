package com.zby.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {
	@RequestMapping("/date")
	public Date date(Date date) {
		return date;
	}
}
