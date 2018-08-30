package com.zby;

import org.springframework.core.io.UrlResource;

public class HResourceMain {

	public static void main(String[] args) throws Exception {
		UrlResource urlResource = new UrlResource("http://www.baidu.com");
		byte[] buffer = new byte[1024 * 1024];
		int read = urlResource.getInputStream().read(buffer);
		System.out.println(new String(buffer, 0, read));
	}

}
