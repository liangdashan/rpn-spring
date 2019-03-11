package com.airwallex.spring.rpn;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.airwallex.spring.rpn.controller.RpnController;


public class DaemonApp {

	public static final LinkedList rpnAllLinkedStack = new LinkedList();
	public static final LinkedList rpnRealNumberLinkedStatck = new LinkedList();
	public static String errdata[] = {};
	private volatile boolean state = true;
	private volatile String inputdata;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void rpngo() {
		new Thread(new Runnable() {
			public void run() {
				getInput();
			}
		}).start();
		dealInput();
	}
	public void getInput() {
		lock.lock();
		try {
			while (state) {
				System.out.print("please key in :");
				Scanner scan = new Scanner(System.in);
				inputdata = scan.nextLine();
				if (inputdata.equals("shutdown")) {
					state = false;
					condition.signal();
					break;
				}
				condition.signal();
				condition.await();
			}

		} catch (InterruptedException e) {
			System.out.println(e.getStackTrace());
		} finally {
			lock.unlock();
		}
	}

	public void dealInput() {
		RpnController rpnController = (RpnController)App.context.getBean("RpnController");
		lock.lock();
		try {
			while (state) {
				condition.await();
				if (inputdata.equals("shutdown")) {
					System.out.println("ths,bye");
					break;
				}
				rpnController.RpnOperator(inputdata, rpnAllLinkedStack, rpnRealNumberLinkedStatck);
				condition.signal();
			}

		} catch (InterruptedException e) {
			System.out.println(e.getStackTrace());
		} finally {
			lock.unlock();
		}
	}
}
