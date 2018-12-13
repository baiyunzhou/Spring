package com.zby.mvc.excel;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

public class ExcelRequestMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private ConcurrentMap<Class<?>, Map<Field, Header>> cache = new ConcurrentHashMap<>(64);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestExcel.class) && List.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		parameter = parameter.nestedIfOptional();
		parameter.increaseNestingLevel();
		Class<?> voClazz = (Class<?>) parameter.getNestedGenericParameterType();
		Map<Field, Header> clazzMap = clazzMap(voClazz);
		RequestExcel requestExcel = parameter.getParameterAnnotation(RequestExcel.class);
		int sheetIndex = requestExcel.sheetIndex();
		int maxRowSize = requestExcel.maxRowSize();
		long maxContentLength = requestExcel.maxContentLength();
		List<String> suffix = Arrays.asList(requestExcel.excelSuffix());
		HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(servletRequest, MultipartHttpServletRequest.class);
		if (null == multipartRequest) {
			throw new RuntimeException("Is Not File Upload.");
		}
		MultipartFile multipartFile = multipartRequest.getFile(requestExcel.name());
		if (null == multipartFile) {
			throw new ExcelNotFoundException(requestExcel.name());
		}
		String fileName = multipartFile.getOriginalFilename();
		if (null == fileName) {
			throw new RuntimeException("File Name null.");
		}
		String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!suffix.contains(fileSuffix)) {
			throw new RuntimeException("Suffix Not Support.");
		}
		InputStream inputStream = multipartFile.getInputStream();
		if (maxContentLength != -1 && multipartFile.getSize() > maxContentLength) {
			throw new RuntimeException("File maxContentLength:" + maxContentLength);
		}
		Workbook workbook = getWorkbook(inputStream, fileSuffix);
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		int rowNum = sheet.getPhysicalNumberOfRows();
		int lastRowNum = sheet.getLastRowNum();
		List<Object> data = new ArrayList<>();
		if (rowNum < 2) {
			return data;
		}
		if (rowNum > maxRowSize + 1) {
			throw new RuntimeException("File maxRowSize:" + maxRowSize);
		}
		for (int i = 1; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);
			if (null == row) {
				continue;
			}
			Object obj = voClazz.newInstance();
			data.add(obj);
			Set<Field> keySet = clazzMap.keySet();
			for (Field field : keySet) {
				Header header = clazzMap.get(field);
				if (null != header) {
					Cell cell = row.getCell(header.index());
					String cellStringData = getCellStringData(cell);
					field.setAccessible(true);
					field.set(obj, cellStringData);
				}

			}
		}
		return data;
	}

	private String getCellStringData(Cell cell) {
		String content = null;
		if (null == cell) {
			return null;
		}
		cell.setCellType(CellType.STRING);
		content = cell.getStringCellValue();
		if (null == content || "".equals(content)) {
			return null;
		}
		return content;
	}

	private Workbook getWorkbook(InputStream inputStream, String fileSuffix) throws Exception {
		Workbook workbook = null;
		if (Constant.EXCEL_2003_SUFFIX.equals(fileSuffix)) {
			workbook = new HSSFWorkbook(inputStream);
		} else if (Constant.EXCEL_2007_SUFFIX.equals(fileSuffix)) {
			workbook = new XSSFWorkbook(inputStream);
		} else {
			throw new Exception("Not Support Suffix.");
		}
		return workbook;
	}

	private Map<Field, Header> clazzMap(Class<?> voClazz) {
		Map<Field, Header> clazzMap = cache.get(voClazz);
		if (null == clazzMap) {
			synchronized (cache) {
				clazzMap = cache.get(voClazz);
				if (null == clazzMap) {
					clazzMap = new HashMap<>();
					Field[] declaredFields = voClazz.getDeclaredFields();
					for (Field field : declaredFields) {
						Header header = field.getDeclaredAnnotation(Header.class);
						clazzMap.put(field, header);
					}
					cache.put(voClazz, clazzMap);
				}
			}

		}
		return clazzMap;
	}
}
