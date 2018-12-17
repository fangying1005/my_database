package com.sxt.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPathDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String baseURI = "/WEB-INF/";
		//response.setHeader("content-type", "text/html;charset=UTF-8");
		//response.setContentType("text/html");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		getPathValue(response, baseURI + "classes/a.properties", out);
		getPathValue(response, baseURI + "classes/com/sxt/servlet/b.properties", out);
		getPathValue(response, baseURI + "c.properties", out);
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * 获取不同文件路径下的文件的内容
	 * @param response 响应
	 * @param path 文件路径
	 * @param out 写到网页的打印流
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void getPathValue(HttpServletResponse response, String path, PrintWriter out) throws IOException,
			FileNotFoundException {
		String pathName = this.getServletContext().getRealPath(path);
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(pathName);
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		//properties.load(fis);
		properties.load(isr);
		String value = properties.getProperty("key");
		System.out.println(value);
		
		//out.println("---------------" + pathName + "===>>>" + value + "-----------------<br/>");
		out.write("---------------" + pathName + "===>>>" + value + "-----------------<br/>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
