package com.zby;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateMain {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://www.baidu.com", String.class);
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());
	}

}
