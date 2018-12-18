package com.lengfeng.tyf.test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// while循环遍历数组
		int[] arr = {11, 22, 33, 44, 55};
		int i = 0;
		while (i < arr.length) {
			System.out.println(arr[i]);
			i++;
		}
		System.out.println("------------");
		// do...while循环遍历数组(当数组长度为0的时候，会报下标越界异常)
		int j = 0;
		do {
			System.out.println(arr[j]);
			j++;
		} while (j < arr.length);
		System.out.println("------------");
		// for循环遍历数组(推荐方式)
		for (int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
		System.out.println("------------");
		System.out.println(Arrays.toString(arr));
		
		int[] arr_new = {1, 2, 3};
		System.arraycopy(arr, 0, arr_new, 1, 2);
		System.out.println(Arrays.toString(arr_new));
		int[] arr_new_1 = Arrays.copyOf(arr, 6);
		System.out.println(Arrays.toString(arr_new_1));

	}

}
