package com.zby.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zby.mvc.excel.RequestExcel;
import com.zby.vo.UserVo;

@Controller
@RequestMapping(path = "/excel")
public class ExcelController {

	@ResponseBody
	@RequestMapping(path = "/importUserVo")
	public List<UserVo> importUserVo(@RequestExcel(name = "UserExcel", maxRowSize = 200) List<UserVo> userVo) {
		System.out.println(userVo);
		return userVo;
	}
}