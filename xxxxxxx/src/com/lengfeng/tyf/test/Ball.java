package com.lengfeng.tyf.test;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 * 创建人:fang
 * 修改时间:2018年10月29日
 * @version v1.0
 */
public class Ball {
	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int time = 1;// 用于记录次数的变量
		double h = 100;// 原高度100米
		double totalH = 0;// 记录总共经过的长度
		while (time <= 10) {// 循环10次
			double temp = h + h / 2;// 定义一个临时变量，存放每一次跳下和反弹回来的长度
			totalH += temp;// 将长度累加到totalH
			h = h / 2;// 每次的高度减成一半
			time++;// 计数器累加
		}
		System.out.println("10次落地共经过: " + totalH + "\n第10次反弹高度为 " + h);// 打印结果
	}
}
