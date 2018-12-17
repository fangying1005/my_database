package com.sxt.verification;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class VerificationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// IE浏览器自动缓存，则验证码不刷新。
		// 告诉客户端不适应缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		//new_verification_code(response);// 自己写验证码
		// 调用别人的验证码
		ValidateCode code = new ValidateCode(110, 25, 4, 9);
		code.write(response.getOutputStream());
	}

	private void new_verification_code(HttpServletResponse response)
			throws IOException {
		// 定义图片高度和宽度
		int width = 110;
		int height = 30;
		// 在内存中创建一个图像对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获得画笔
		Graphics g = image.getGraphics();
		// 给图片添加背景颜色
		g.setColor(Color.PINK);// 设置颜色
		g.fillRect(1, 1, width - 2, height - 2);// 填充颜色
		// 给边框添加一个颜色
		g.setColor(Color.RED);// 设置颜色
		g.drawRect(0, 0, width - 1, height - 1);// 设置边框的颜色
		// 设置文本样式
		g.setColor(Color.BLUE);// 设置颜色
		g.setFont(new Font("华文隶书", Font.BOLD | Font.ITALIC, 30));// 设置字体
		// 给图片添加文本
		Random random = new Random();// 获取随机数对象
		int position = 18;// 图片第一个文字的起始横坐标
		for (int i = 0; i < 4; i++) {
			g.drawString(random.nextInt(10) + "", position, 25);// 给图片填充文字
			position += 20;
		}
		// 添加9条干扰线
		g.setColor(Color.GRAY);
		for (int i = 0; i < 9; i++) {
			// 给图片填充干扰线
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}
		
		// 将图片对象以流的方式输出到客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
