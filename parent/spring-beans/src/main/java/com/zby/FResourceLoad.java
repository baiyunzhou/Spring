package com.zby;

import java.io.InputStream;

public class FResourceLoad {

	public static void main(String[] args) throws Exception {
		// 实际上也是通过类加载器获取资源，只不过会对路径做处理
		// 不是以/开头的路径，会获取到这个类的包名，用/代替.然后拼接上资源路径，这儿的EParseStateMain.class会变成com/zby/EParseStateMain.class
		InputStream resourceAsStream1 = FResourceLoad.class.getResourceAsStream("EParseStateMain.class");
		// 以/开头的路径，直接去掉/，这儿的/com/zby/EParseStateMain.class变成com/zby/EParseStateMain.class
		InputStream resourceAsStream2 = FResourceLoad.class.getResourceAsStream("/com/zby/EParseStateMain.class");
		// 然后将上面得到的资源路径，使用类加载器加载，首先使用当前类所用的类加载器，没有的话使用系统类加载器
		System.out.println(resourceAsStream1.available());
		System.out.println(resourceAsStream2.available());
		System.out.println(FResourceLoad.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		InputStream resourceAsStream3 = FResourceLoad.class.getClassLoader().getResourceAsStream("com/zby/EParseStateMain.class");
		InputStream resourceAsStream4 = ClassLoader.getSystemClassLoader().getResourceAsStream("com/zby/EParseStateMain.class");
		System.out.println(resourceAsStream3.available());
		System.out.println(resourceAsStream4.available());
	}

}
