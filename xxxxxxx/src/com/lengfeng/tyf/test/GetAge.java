package com.lengfeng.tyf.test;

/**
 * 有5个人坐在一起，第五个人多少岁？他说比第4个人大2岁。第4个人岁数，他说比第3个人大2岁。第三个人，又说比第2人大两岁。第2个人，说比第一个人大两岁。
 * 最后问第一个人，他说是10岁。请问第五个人多大？(使用递归算法)
 * 创建人:fang
 * 修改时间:2018年10月27日
 * @version v1.0
 */
public class GetAge {
	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(getAge(5));// 打印第五个人的年龄
	}

	/**
	 * 返回地几个人的年龄
	 * 
	 * @param personNums 人数
	 * @return
	 */
	public static int getAge(int personNums) {
		if (personNums == 1) {// 第一个人的年龄
			return 10;// 返回年龄
		} else {// 除第一个人外的其他人
			return getAge(personNums - 1) + 2;// 都是前一个人的年龄+2
		}
	}
}
