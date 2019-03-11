package com.airwallex.spring.rpn.service.impl;


import com.airwallex.spring.rpn.exception.RpnException;
import com.airwallex.spring.rpn.service.RpnOperateService;

import static com.airwallex.spring.rpn.exception.DefaultRetMsg.OPERATOR_EXCEPTION;
import static com.airwallex.spring.rpn.utils.RpnCalculate.DataPlus;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;


public class RpnOperatePlusServiceImpl implements RpnOperateService {

	/*
	 * 加法
	 */


	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args)  {
		if (rpnRealNumberLinkedStatck.size() <= 1)
			throw new RpnException(OPERATOR_EXCEPTION , args[0]);
		rpnAllLinkedStack.addLast(data);
		Object firstdata = rpnRealNumberLinkedStatck.pollLast();
		Object seconddata = rpnRealNumberLinkedStatck.pollLast();
		rpnRealNumberLinkedStatck.addLast(DataPlus(firstdata, seconddata));
	}
}
