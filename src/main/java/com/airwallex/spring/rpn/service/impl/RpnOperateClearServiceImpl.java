package com.airwallex.spring.rpn.service.impl;

import com.airwallex.spring.rpn.exception.RpnException;
import com.airwallex.spring.rpn.service.RpnOperateService;

import java.util.LinkedList;

import org.springframework.stereotype.Service;


public class RpnOperateClearServiceImpl implements RpnOperateService {

	/*
	 * 清空父链与子链
	 */
	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) {
		rpnAllLinkedStack.clear();
		rpnRealNumberLinkedStatck.clear();
	}

}
