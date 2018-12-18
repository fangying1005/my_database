package com.lengfeng.tyf.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Calc {

	public static void main(String[] args) throws Exception {
		// test1();
		// Java源代码
		// String sourceStr = "public class Hello{public String sayHello(String name){return \"Hello, \"+name;}}";
		String sourceStr = "public class Hello{public int calc(){return 13+22-35/44*56+(62/3*6+8-4);}}";
		// 类及文件名
		String clsName = "Hello";
		// 方法名
		String methodName = "calc";
		/**
		 * 当前编译器：注意，如果是用的jdk1.6的版本（建议使用jdk1.7，1.7是没有任何问题的），ToolProvider.
		 * getSystemJavaCompiler()拿到的对象将会为null，
		 * 原因是需要加载的Tools.jar不在jdk安装目录的jre目录下，需要手动将lib目录下的该jar包拷贝到jre下去，详情请参考：
		 * http://www.cnblogs.com/fangwenyu/archive/2011/10/12/2209051.html
		 */
		JavaCompiler cmp = ToolProvider.getSystemJavaCompiler();
		// Java标准文件管理器
		StandardJavaFileManager fm = cmp.getStandardFileManager(null, null, null);
		// Java文件对象
		JavaFileObject jfo = new StringJavaObject(clsName, sourceStr);
		// 编译参数，类似于javac <options> 中的options
		List<String> optionsList = new ArrayList<String>();
		// 编译文件的存放地方，注意：此处是为Eclipse工具特设的
		optionsList.addAll(Arrays.asList(new String[] { "-d", "./bin" }));
		// 要编译的单元
		List<JavaFileObject> jfos = Arrays.asList(new JavaFileObject[] { jfo });
		// 设置编译环境
		JavaCompiler.CompilationTask task = cmp.getTask(null, fm, null, optionsList, null, jfos);
		// 编译成功
		if (task.call()) {
			// 生成对象
			Object obj = Class.forName(clsName).newInstance();
			Class<? extends Object> cls = obj.getClass();
			// 调用sayHello方法
			Method m = cls.getMethod(methodName);
			// 第一个参数是执行该方法的主调，后面若干个参数是执行该方法时传入该方法的实参
			Integer num = (Integer) m.invoke(obj);
			System.out.println(num);
		}
	}

	public static void test1() {
		String str = "13+22-35/44*56+(62/3*6+8-4)";

		String regex = "(\\D*)(\\d+)(\\D*)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			System.out.println(matcher.group(2) + ", " + matcher.group(3));
		}
	}

}
