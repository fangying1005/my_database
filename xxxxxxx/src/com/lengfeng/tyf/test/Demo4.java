package com.lengfeng.tyf.test;

public class Demo4 {

	public Demo4() {
	}
	
	public Demo4(String name) {
		this();
	}
	
	public static void main(String[] args) {
		// 雇员1
		String emp1Name = "黄河大虾";
		int emp1Age = 25;
		char emp1Gender = '男';
		double emp1Salary = 8000.00;
		boolean s = false;
		// 打印员工信息
		printEmpInfo(emp1Name, emp1Age, emp1Gender, emp1Salary);

		// 修改员工工资（增长20%）并打印
		emp1Salary *= 120.0 / 100.0;
		printEmpInfo(emp1Name, emp1Age, emp1Gender, emp1Salary);
	}

	/**
	 * 打印员工信息的方法
	 * 
	 * @param name 员工姓名
	 * @param age 员工年龄
	 * @param gender 员工性别
	 * @param salary 员工工资
	 */
	public static void printEmpInfo(String name, int age, char gender, double salary) {
		System.out.println("--------------------");
		System.out.println("姓名： " + name);
		System.out.println("年龄：" + age);
		System.out.println("性别：" + gender);
		System.out.println("薪水：" + salary);
	}
}
