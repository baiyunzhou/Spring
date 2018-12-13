package com.zby.mvc.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestExcel {
	/**
	 * excel表单参数名字
	 */
	String name();

	/**
	 * sheet索引
	 */
	int sheetIndex() default 0;

	/**
	 * 上传文件大小
	 */
	long maxContentLength() default -1;

	/**
	 * 最大行数
	 */
	int maxRowSize() default 2000;

	/**
	 * excel允许的后缀名
	 */
	String[] excelSuffix() default { Constant.EXCEL_2003_SUFFIX, Constant.EXCEL_2007_SUFFIX };

}
