package com.lengfeng.tyf.test;

public class Demo3 {

	public static void main(String[] args) {

		double d = 100;
		System.out.println(d);
		int count = getDecimalCountByStr(d);

		System.out.println("小数位数:" + count);
		count = getDecimalCount(d);

		System.out.println("小数位数:" + count);

	}

	/**
	 * 获取小数点后面的位数
	 * 
	 * @param d_num 小数
	 * @return 小数位数
	 */
	public static int getDecimalCountByStr(double d_num) {
		String str = d_num + "";// 将浮点数转成字符串
		int index = str.indexOf(".");
		System.out.println("index:" + index);
		if (index == -1) {// 如果浮点数中不包含小数点"."
			return 0;// 表示无小数
		}
		int length = str.length();// 获取整个字符串的长度
		return length - 1 - index;// 返回小数的位数
	}
	
	/**
	 * 获取小数点后面的位数
	 * 	缺点:只能精确到17位小数
	 * @param d_num 小数
	 * @return 小数位数
	 */
	public static int getDecimalCount(double d_num) {
		if (d_num == (long) d_num) {
			return 0;
		}
		int count = 0;// 记录小数点后面位数的变量
		while (true) {// 死循环进行计算
			count++;// 计数器累加
			if (d_num * Math.pow(10, count) % 1 == 0) {// 将浮点数乘以10的count次方, 再与1取余数
				break;// 当余数为0, 停止循环
			}
		}
		return count;// 返回小数的位数
	}
}
