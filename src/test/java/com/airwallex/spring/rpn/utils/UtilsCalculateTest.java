package com.airwallex.spring.rpn.utils;

import java.math.BigDecimal;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class UtilsCalculateTest {


	
	public static final LinkedList rpnAllLinkedStack = new LinkedList();
	public static final LinkedList rpnRealNumberLinkedStatck = new LinkedList();
	
	@Before
	public void add(){
		rpnAllLinkedStack.addLast("9");
		rpnRealNumberLinkedStatck.addLast("10");
		rpnAllLinkedStack.addLast("50");
		rpnRealNumberLinkedStatck.addLast("100");
	}
	
	/*
	 * 加减乘除四则运算
	 */
	@Test
	public void test() {
		System.out.println(RpnCalculate.DataSqrt(""));
		System.out.println(RpnCalculate.DataDiv("5", "2"));
		System.out.println(RpnCalculate.DataMinus("5", "2"));
		System.out.println(RpnCalculate.DataMulti("5", "2"));
		System.out.println(RpnCalculate.DataPlus("5", "2"));
		
		
		//测试格式化
		System.out.println(RpnCalculate.formatBigDecimal(new BigDecimal("7.55556633288")));
		
		
		//循环输出
		System.out.println(RpnCalculate.outputdata(rpnRealNumberLinkedStatck));
		
	}
	
	/*
	 * 检查是否是数字
	 */
	@Test
	public void testconfirm() {
		System.out.println(RpnCalculate.isNum("00aaaaa"));
		
	}
}
