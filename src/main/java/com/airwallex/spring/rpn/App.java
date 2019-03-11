package com.airwallex.spring.rpn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author liangjl
 * 启动目录
 */
public class App {

	public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:rpnaop.xml ");
	public static void main(String[] args) {
		System.out.println("welcome to use RPN !!! \r\nshutdown is the key of out");
		context.registerShutdownHook();
	    context.start();
	    DaemonApp DA= (DaemonApp)context.getBean("daemonapp");
	    DA.rpngo();
	}
	
}
