package com.sxt.servletconfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet {

	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String str = servletConfig.getInitParameter("encoding");
		System.out.println("-------------" + str + "---------------");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
