package com.zby.mvc.excel;

public class ExcelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcelNotFoundException(String excelName) {
		super("No Excel Named 【" + excelName + "】 found.");
	}

}
