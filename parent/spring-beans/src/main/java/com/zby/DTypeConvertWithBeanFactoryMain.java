package com.zby;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import com.zby.bean.InnerDateBean;

@SuppressWarnings("deprecation")
public class DTypeConvertWithBeanFactoryMain {

	public static void main(String[] args) {

		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-typeConvert.xml"));
		// 方法一：注册Converter，ApplicationContext对应ConversionServiceFactoryBean
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new MyCustomDateConverter());
		beanFactory.setConversionService(conversionService);
		// 方法二：添加属性编辑器注册器，ApplicationContext对应CustomEditorConfigurer
		beanFactory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true, -1));
			}
		});
		// 方法三：直接注册属性编辑器，ApplicationContext对应CustomEditorConfigurer
		beanFactory.registerCustomEditor(Date.class, MyCustomDateEditor.class);
		InnerDateBean innerDateBean = (InnerDateBean) beanFactory.getBean("innerDateBean");
		System.out.println(innerDateBean);
	}

	private static class MyCustomDateEditor extends CustomDateEditor {

		public MyCustomDateEditor() {
			super(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true, -1);
		}

	}

	private static class MyCustomDateConverter implements Converter<String, Date> {

		@Override
		public Date convert(String source) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return simpleDateFormat.parse(source);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}

	}

	/**
	 * 
	 * @author zhoubaiyun
	 * @date 2018年7月13日
	 * @Description
	 */
	public static void testSimpleDateFormat() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println("这个居然能转换，但是看着不对啊:" + simpleDateFormat.parse("1999--09--09 09:09:09/////asdfasd").toLocaleString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
