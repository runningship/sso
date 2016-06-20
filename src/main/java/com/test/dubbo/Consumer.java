package com.test.dubbo;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.json.JSONObject;

public class Consumer {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo.xml" });
		context.start();

		IDemoService demoService = (IDemoService) context.getBean("demoService"); //
		String hello = demoService.sayHello("tom"); // ִ
		System.out.println(hello); //

		Object result = demoService.call("getDogById", new HashMap());
		System.out.println(result);
		result = demoService.call("getCatList", new HashMap());
		System.out.println(result);
		// System.in.read();
	}
}
