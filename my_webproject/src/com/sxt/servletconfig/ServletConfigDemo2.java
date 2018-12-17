package com.sxt.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = super.getInitParameter("encoding");
		String initParameter = this.getInitParameter("encoding");
		String parameter = this.getServletConfig().getInitParameter("encoding");
		System.out.println("-------------" + str + "---------------");
		System.out.println("-------------" + initParameter + "---------------");
		System.out.println("-------------" + parameter + "---------------");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
