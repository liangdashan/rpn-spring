package com.airwallex.spring.rpn.service.impl;

import com.airwallex.spring.rpn.exception.RpnException;
import com.airwallex.spring.rpn.service.RpnOperateService;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import static com.airwallex.spring.rpn.exception.DefaultRetMsg.OPERATOR_EXCEPTION;
import static com.airwallex.spring.rpn.utils.RpnCalculate.DataDiv;
import static com.airwallex.spring.rpn.utils.RpnCalculate.DataSqrt;


public class RpnOperateDivServiceImpl implements RpnOperateService {

	/*
	 * 压入rls 取rpnRealNumberLinkedStatck 最后两个节点计算 异常：最后一个节点为0；
	 * rpnRealNumberLinkedStatck不到两个节点； 除法
	 */

	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck,
			Object... args) {
		if (rpnRealNumberLinkedStatck.size() <= 1)
			throw new RpnException(OPERATOR_EXCEPTION, args[0]);
		rpnAllLinkedStack.addLast(data);
		Object firstNumber = rpnRealNumberLinkedStatck.pollLast();
		Object secondNumber = rpnRealNumberLinkedStatck.pollLast();
		rpnRealNumberLinkedStatck.addLast(secondNumber);
		rpnRealNumberLinkedStatck.addLast(firstNumber);
		rpnRealNumberLinkedStatck.addLast(DataDiv(secondNumber, firstNumber, args));
		Object thirdNumber = rpnRealNumberLinkedStatck.pollLast();
		firstNumber = rpnRealNumberLinkedStatck.pollLast();
		secondNumber = rpnRealNumberLinkedStatck.pollLast();
		rpnRealNumberLinkedStatck.addLast(thirdNumber);
	}
}
