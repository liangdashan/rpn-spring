package com.airwallex.spring.rpn.service.impl;

import static com.airwallex.spring.rpn.utils.RpnConfirm.typeConfirm;
import static com.airwallex.spring.rpn.utils.RpnDealData.dealInputData;
import static com.airwallex.spring.rpn.utils.RpnLoadClass.loadImpl;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.airwallex.spring.rpn.service.RpnOperateService;


public class RpnOperateUndoServiceImpl implements RpnOperateService {

	/*
	 * 重新生成栈
	 */

	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck,
			Object... args) {
		rpnRealNumberLinkedStatck.clear();
		rpnAllLinkedStack.pollLast();
		// 生成新的备用全栈
		LinkedList bakRpnAllLinkedStack = new LinkedList();
		for (Object baknode : rpnAllLinkedStack) {
			bakRpnAllLinkedStack.addLast(baknode);
		}
		rpnAllLinkedStack.clear();
		// 重新入栈
		for (Object nodedata : bakRpnAllLinkedStack) {
			String objectType = typeConfirm(nodedata);
			Object OperatorClass = loadImpl("com.airwallex.spring.rpn.service.impl." + "RpnOperate" + objectType + "ServiceImpl");
			RpnOperateService ros = (RpnOperateService) OperatorClass;
			ros.calculate(nodedata, rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		}
	}

}
