package com.sxt.location;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class LocationServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("我要借钱!");
		System.out.println("我没有，但是可以找他借!");
		
		response.setContentType("text/html;charset=utf-8");
		// 告诉浏览器要重新定向新的资源
		//response.setStatus(302);
		// 告诉浏览器要去访问那个URL
		///response.setHeader("location", "/my_webproject/location/demo2");
		// 请求重定向
		response.sendRedirect("/my_webproject/location/demo2");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("我要借钱!");
		out.print("我没有，但是可以找他借!");
		out.print("我去了!");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我去了!");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
