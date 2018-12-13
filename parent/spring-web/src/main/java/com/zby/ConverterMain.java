package com.zby;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class ConverterMain {

	public static void main(String[] args) {
		HttpMessageConverter<Object> httpMessageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypes = httpMessageConverter.getSupportedMediaTypes();
		System.out.println(mediaTypes);
		boolean canRead = httpMessageConverter.canRead(Entity.class, MediaType.APPLICATION_JSON_UTF8);
		System.out.println(canRead);
	}

	class Entity {

	}
}
