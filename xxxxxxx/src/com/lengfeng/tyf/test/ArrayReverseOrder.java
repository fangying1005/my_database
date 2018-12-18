package com.lengfeng.tyf.test;

import java.util.Scanner;

/**
 * 将一个数组逆序输出。
 * 当a数组以实参传入函数Fun()时,函数内部对形参的操作改变了原始数组a的值,
 * 这是因为数组传递的是引用,对引用的操作就是对原本数组的操作
 * 创建人:fang
 * 修改时间:2018年10月29日
 * @version v1.0
 */
public class ArrayReverseOrder {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);// 构建控制台输入的对象
		System.out.println("请输入需要逆序数组的大小:");
		int length = input.nextInt();// 接收输入的整数
		if (length <= 0) {// 做简单的判断
			System.out.println("您不需要进行逆序操作, 程序结束...");
			System.exit(0);// 退出程序
		}
		int[] arr = new int[length];// 定义一个大小为length的数组
		for (int i = 0; i < arr.length; i++) {// 循环数组长度的次数
			arr[i] = input.nextInt();// 将输入的整数，赋值给数组
		}
		input.close();// 关闭输入的通道
		reverseArray(arr);// 逆序
		for (int i = 0; i < arr.length; i++) {// 循环打印数组的每一个元素
			System.out.print(arr[i] + " ");// 打印数组的每一个元素
		}
	}

	/**
	 * 将数组逆序
	 * 
	 * @param arr
	 */
	public static void reverseArray(int[] arr) {
		int i;
		int j;
		int k;
		int time;
		if (arr.length % 2 == 0) {// 如果数组的长度为偶数
			i = 0;// 左边下标(第一个元素的下标)
			j = arr.length - 1;// 右边下标(最后一个元素的下标)
			while (i + 1 != j) {// 循环条件是左边下标不等于右边下标
				// 交换元素的位置
				time = arr[i];
				arr[i] = arr[j];
				arr[j] = time;
				i++;// 左边下标右移1个大小
				j--;// 右边下标左移1个大小
			}
		} else {
			i = 0;// 左边下标(第一个元素的下标)
			j = arr.length - 1;// 右边下标(最后一个元素的下标)
			k = (arr.length + 1) / 2 - 1; // 中间数组的下标
			while (i != k) {// 循环条件是左边下标不等于右边下标(正中间的一个元素不需要动)
				// 交换元素的位置
				time = arr[i];
				arr[i] = arr[j];
				arr[j] = time;
				i++;// 左边下标右移1个大小
				j--;// 右边下标左移1个大小
			}
		}
	}
}
