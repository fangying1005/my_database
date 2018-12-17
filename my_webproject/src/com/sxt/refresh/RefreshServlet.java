package com.sxt.refresh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshServlet extends HttpServlet {

	static int num = 10;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//Random random = new Random();
		//out.write(random.nextInt() + "");
		
		if (num >= 0) {
			out.write(num + "秒");
			response.setHeader("refresh", "1");
			num--;
		} else {
			out.write("886");
			out.write("注册成功！3秒钟跳转主页");
			response.setHeader("refresh", "3;url=/my_webproject/refresh/demo2");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
