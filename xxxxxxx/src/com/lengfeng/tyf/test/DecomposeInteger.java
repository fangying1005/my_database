package com.lengfeng.tyf.test;

import java.util.Scanner;
import java.lang.*;

/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
 * 创建人:fang
 * 修改时间:2018年10月29日
 * @version v1.0
 */
public class DecomposeInteger {
	public static void main(String[] args) {
		int[] a = new int[30];
		int i = 0;
		int number = 0;
		int time = 2;
		Scanner in = new Scanner(System.in);
		try {
			number = in.nextInt();
		} catch (Exception e) {
			System.out.println("输入有误!");
		}
		while (calculatePrimeNumber(number) == false) {
			while (number % time != 0) {
				time++;
			}
			number = number / time;
			a[i++] = time;
			time = 2;
		}
		a[i] = number;
		for (int forTime = 0; forTime <= i; forTime++) {
			if (forTime == 0) {
				System.out.print("=" + a[forTime]);
			} else {
				System.out.print("*" + a[forTime]);
			}
		}

	}

	/**
	 * 判断一个数是否是质数
	 * @param number
	 * @return
	 */
	public static boolean calculatePrimeNumber(int number) {
		double numberSqrt = Math.sqrt(number);// 求number的平方根
		for (int i = 2; i <= numberSqrt; i++) {
			if (number % i == 0) {// 代表num被i整除
				return false;// 返回不是质数
			}
		}
		return true;// 返回是质数
	}
}