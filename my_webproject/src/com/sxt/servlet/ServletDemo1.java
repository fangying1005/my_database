package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet {
	
	public ServletDemo1() {
		System.out.println("***********ServletDemo1方法执行了***************");
	}
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("***********init方法执行了***************");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("***********service方法执行了***************");
	}

	@Override
	public void destroy() {
		System.out.println("***********destroy方法执行了***************");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
}
