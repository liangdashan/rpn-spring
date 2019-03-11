package com.airwallex.spring.rpn.utils;

import java.math.BigDecimal;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class UtilsConfirmTest {


	
	
	/*
	 * 检查是什么类型
	 */
	@Test
	public void test() {
		System.out.println(RpnConfirm.typeConfirm("*"));
		System.out.println(RpnConfirm.typeConfirm("-"));
		System.out.println(RpnConfirm.typeConfirm("+"));
		System.out.println(RpnConfirm.typeConfirm("/"));
		System.out.println(RpnConfirm.typeConfirm("0.1"));
		System.out.println(RpnConfirm.typeConfirm("?"));
	}
	
	
}
