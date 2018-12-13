package com.zby.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello(int num) {
		int i = 10 / num;
		return "Hello,World!" + i;
	}

	@RequestMapping("/list")
	public List<String> list(ArrayList<String> list) {
		System.out.println(list);
		return list;
	}
}
