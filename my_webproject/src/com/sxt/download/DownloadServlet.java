package com.sxt.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/image.jpg");
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = response.getOutputStream();
		
		String fileName = path.substring(path.lastIndexOf('\\') + 1);
		fileName = URLEncoder.encode(path, "UTF-8");
		// 告知客户端要下载文件
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		response.setHeader("content-type", "image/jpg");
		
		int len = 1;
		byte[] arr = new byte[1024];
		while ((len = fis.read(arr)) != -1) {
			sos.write(arr, 0, len);
		}
		sos.close();
		fis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
