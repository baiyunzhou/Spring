package com.zby;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

public class HResourceMain {

	public static void main(String[] args) throws Exception {
		UrlResource urlResource = new UrlResource("http://www.baidu.com");
		byte[] buffer = new byte[1024 * 1024];
		int read = urlResource.getInputStream().read(buffer);
		System.out.println(new String(buffer, 0, read));
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("http://www.baidu.com");
		byte[] buffer2 = new byte[1024 * 1024];
		int read2 = resource.getInputStream().read(buffer2);
		System.out.println(new String(buffer2, 0, read2));
	}

}
