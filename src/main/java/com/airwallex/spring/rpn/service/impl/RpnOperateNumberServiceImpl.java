package com.airwallex.spring.rpn.service.impl;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.airwallex.spring.rpn.service.RpnOperateService;


public class RpnOperateNumberServiceImpl implements RpnOperateService {

	/*
	 * 直接入栈
	 */
	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) {
		rpnRealNumberLinkedStatck.addLast(data);
		rpnAllLinkedStack.addLast(data);
	}

}
