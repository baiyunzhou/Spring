package com.zby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeMarkerController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(String name, Model model) {
		model.addAttribute("message", "hello");
		model.addAttribute("name", name);
		return "index";
	}
}
