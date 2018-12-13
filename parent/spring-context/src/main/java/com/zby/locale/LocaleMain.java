package com.zby.locale;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleMain {

	public static void main(String[] args) {
		ResourceBundle chinese = ResourceBundle.getBundle("msg", Locale.CHINESE);
		String chineseName = chinese.getString("name");
		System.out.println(chineseName);
		ResourceBundle us = ResourceBundle.getBundle("msg", Locale.US);
		String usName = us.getString("name");
		System.out.println(usName);
		MessageFormat chineseFormat = new MessageFormat("{0}{1,time}", Locale.CHINESE);
		Object[] params = new Object[] { "中国时间：", new Date() };
		String chineseResult = chineseFormat.format(params);
		System.out.println(chineseResult);
		MessageFormat usFormat = new MessageFormat("{0}{1,time}", Locale.US);
		Object[] usParams = new Object[] { "USA time:", new Date() };
		String usResult = usFormat.format(usParams);
		System.out.println(usResult);
	}

}
