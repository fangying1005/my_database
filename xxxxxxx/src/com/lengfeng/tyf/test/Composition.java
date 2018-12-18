package com.lengfeng.tyf.test;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+222,2+222,22(此时共有5个数相加)，
 * 几个数相加有键盘控制。
 * 1.程序分析：关键是计算出每一项的值。
 *
 * 创建人:fang
 * 修改时间:2018年10月29日
 * @version v1.0
 */
public class Composition {
	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(calculate(2, 4));
	}

	/**
	 * 计算
	 * 
	 * @param baseData 基数(就是最小单元的数)
	 * @param comTime 计算次数(最大位数/加数的个数)
	 * @return 计算的结果
	 */
	public static long calculate(int baseData, int comTime) {
		long result = 0;// 存放最后和的变量
		int time = 0;// 控制循环的变量(计数器)
		int nowData = 0;// 记录当次循环，
		int lastData = 0;// 用于保存上一次记录的数
		/*
		 * 当baseData=2, comTime=4时: 2+22+222+2222=?
		 * 分析: 2=2*10的0次方
		 * 		22=2*10的1次方+2(2=2*10的0次方)
		 * 		222=2*10的2次方+22(22=2*10的1次方+2)
		 * 		2222=2*10的3次方+222(2*10的2次方+22)
		 * 循环四次：每一次计算一个加数，每次的结果作为下次计算的值
		 */
		while (time < comTime) {// 加数个数循环(有几个数相加, 循环几次)
			// baseData * (int) Math.pow(10, time++)为每一次的最高位，lastData记录上次循环的结果
			nowData = baseData * (int) Math.pow(10, time++) + lastData;// 计算出每一个加数的值(如:2、22、222、2222)
			result += nowData;// 将每一项的值累加的最终的结果上面
			lastData = nowData;// 保存上一次循环计算的结果(加数)
			time++;// 计数器累加
			System.out.println(nowData);// 打印每一次计算的结果
		}
		return result;
	}
}