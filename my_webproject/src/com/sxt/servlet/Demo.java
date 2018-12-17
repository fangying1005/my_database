package com.sxt.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("D:\\project_code\\workspace\\my_webproject\\src\\com\\sxt\\servlet\\b.properties"));
		String value = properties.getProperty("key");
		System.out.println(value);
	}

}
