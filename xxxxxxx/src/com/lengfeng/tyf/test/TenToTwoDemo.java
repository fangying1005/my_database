package com.lengfeng.tyf.test;

/**
 * 将十进制数转二进制数
 * 创建人:fang
 * 修改时间:2018年11月17日
 * 
 * @version v1.0
 */
public class TenToTwoDemo {

	public static void main(String[] args) {
		double d = 10.125;

		// 1.获取整数部分
		int i_num = (int) d;
		// 2.获取小数部分
		double d_num = d - i_num;
		System.out.println("小数部分是:" + i_num + ", 小数部分是:" + d_num);

		// 3.将整数部分转成二进制数
		String result = "";// 保存最后结果的变量

		do {
			int mod = i_num % 2;// 得到除2后的余数
			result = mod + result;// 将每一次的余数, 反着累加到结果变量result上
			int shang = i_num / 2;// 每次除以2, 作为循环的出口判断条件
			if (shang == 0) {// 当商为0, 退出循环
				break;// 退出循环
			}
			i_num = shang;// 每一次的被除数，都是上一次的商

		} while (true);
		System.out.println("整数部分转二进制数的结果是:" + result);
		// 4.将结果result末尾拼接字符串"."
		result += ".";
		// 5.将小数部分转成二进制数
		do {
			double ji = d_num * 2;// 每一次拿小数部分乘以2

			int n = (int) ji;// 每次乘以2后, 将积取整, 得到二进制数, 累加到结果result上
			result += n;// 将得到的二进制数, 依次累加到结果result后面
			if (ji == 1) {// 当乘2的积为1时, 退出循环
				break;// 退出循环
			}
			d_num = ji;// 每一次乘2的积, 作为下一次的乘数

		} while (true);
		System.out.println("整数部分转二进制数的结果是:" + result);
	}

	/***************以下是方法封装**************************/
	
	/**
	 * 将整数部分转成二进制数
	 * 
	 * @param ten_num
	 * @return
	 */
	public static String getTwoStr(int ten_num) {
		String result = "";// 保存最后结果的变量

		do {
			int mod = ten_num % 2;// 得到除2后的余数
			result = mod + result;// 将每一次的余数, 反着累加到结果变量result上
			int shang = ten_num / 2;// 每次除以2, 作为循环的出口判断条件
			if (shang == 0) {// 当商为0, 退出循环
				break;// 退出循环
			}
			ten_num = shang;// 每一次的被除数，都是上一次的商

		} while (true);
		return result;
	}

	/**
	 * 获取小数点后面的位数
	 * 缺点:只能精确到17位小数
	 * 
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
			if (d_num * Math.pow(10, count) % 1 == 0) {// 将浮点数乘以10的count次方,
														// 再与1取余数
				break;// 当余数为0, 停止循环
			}
		}
		return count;// 返回小数的位数
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
	 * 将浮点数, 转成整数
	 * 
	 * @param count 小数点的位数
	 * @param d_num 浮点数
	 * @return 整数
	 */
	public static int getInteger(int count, double d_num) {
		d_num *= Math.pow(10, count);// 将小数乘以10的count次方
		return (int) d_num;// 取整返回
	}

}
