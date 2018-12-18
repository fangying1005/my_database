package com.lengfeng.tyf.test;

/**
 * 测试代码
 * 创建人:fang
 * 修改时间:2018年12月17日
 * 
 * @version v1.0
 */
public abstract class Demo {

	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.setA(3);
		t.setB(4);
		t.setC(5);
		double area = t.area();
		System.out.println(area);
	}

}

/**
 * 形状类
 * 创建人:fang
 * 修改时间:2018年12月17日
 * 
 * @version v1.0
 */
abstract class Shape {
	/**
	 * 计算面积的方法
	 * 
	 * @return
	 */
	public abstract double area();

	/**
	 * 计算周长的方法
	 * 
	 * @return
	 */
	public abstract double perimeter();
}

/**
 * 矩形类
 * 创建人:fang
 * 修改时间:2018年12月17日
 * 
 * @version v1.0
 */
class Rectangle extends Shape {

	private double length;// 长
	private double width;// 宽

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double area() {
		return getLength() * getWidth();
	}

	@Override
	public double perimeter() {
		return 2 * (getWidth() + getWidth());
	}
}

/**
 * 三角形类
 * 创建人:fang
 * 修改时间:2018年12月17日
 * 
 * @version v1.0
 */
class Triangle extends Shape {

	private double a, b, c;// 三边边长

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public double area() {
		double p = (getA() + getB() + getC()) / 2;
		return Math.sqrt(p * (p - getA()) * (p - getB()) * (p - getC()));
	}

	@Override
	public double perimeter() {
		return getA() + getB() + getC();
	}

}

/**
 * 圆形类
 * 创建人:fang
 * 修改时间:2018年12月17日
 * 
 * @version v1.0
 */
class Circle extends Shape {

	private double diameter;// 直径

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(getDiameter() / 2, 2);
	}

	@Override
	public double perimeter() {
		return Math.PI * getDiameter();
	}

}