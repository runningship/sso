package com.test.dubbo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo.xml" });
		context.start();

		IDemoService demoService = (IDemoService) context.getBean("demoService"); //
		String hello = demoService.sayHello("tom"); // ִ
		System.out.println(hello); //

		//
		List list = demoService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		// System.in.read();
	}
}
