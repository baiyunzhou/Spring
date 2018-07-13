package com.zby;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.ClassPathResource;

import com.zby.bean.InnerDateBean;

@SuppressWarnings("deprecation")
public class DTypeConvertWithBeanFactoryMain {

	public static void main(String[] args) {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-typeConvert.xml"));
		beanFactory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true, -1));
			}
		});
		beanFactory.registerCustomEditor(Date.class, MyCustomDateEditor.class);
		InnerDateBean innerDateBean = (InnerDateBean) beanFactory.getBean("innerDateBean");
		System.out.println(innerDateBean);
	}

	private static class MyCustomDateEditor extends CustomDateEditor {

		public MyCustomDateEditor() {
			super(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true, -1);
		}

	}
}
