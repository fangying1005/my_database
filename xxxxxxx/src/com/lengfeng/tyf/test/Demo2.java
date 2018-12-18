package com.lengfeng.tyf.test;

public class Demo2 {
	public static void main(String[] args) {
		int money = 20;
		int price = 3;
		
		int temp = 0;
		int change = 0;
		
		int sum = 0;
		
		while (money >= price) {
			temp = money / price;
			sum += temp;
			change = money % price;
			money = temp + change;
		}
		System.out.println(sum);
	}
}
