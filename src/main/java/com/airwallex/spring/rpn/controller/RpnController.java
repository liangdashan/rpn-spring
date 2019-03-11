package com.airwallex.spring.rpn.controller;

import static com.airwallex.spring.rpn.utils.RpnCalculate.outputdata;
import static com.airwallex.spring.rpn.utils.RpnConfirm.typeConfirm;
import static com.airwallex.spring.rpn.utils.RpnDealData.dealInputData;
import static com.airwallex.spring.rpn.utils.RpnDealData.findInputDataIndex;

import java.util.LinkedList;
import java.util.List;
import static com.airwallex.spring.rpn.utils.RpnLoadClass.loadImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.airwallex.spring.rpn.service.RpnOperateService;
import static com.airwallex.spring.rpn.DaemonApp.errdata;
/*
 * @author liangjl
 * @date 2019/3/8
 * 通过反射动态调用不同的serviceImpl
 */
public class RpnController {
	
	
	private static Logger logger = Logger.getLogger(RpnController.class.getClass());
	
	/*
	 * 操作impl
	 * 根据不同的操作方式来选择，这里不使用Autowired进行注入，而使用反射的方式解决，保证灵活性
	 */
	private RpnOperateService ros;


	public void RpnOperator(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck){
		// 全部入栈的标志
		boolean allin = true;
		// 每次剩余的字符串
		String[] lastdata = null;
		// 一个一个压入栈中
		int dataorder = 0;
		for (Object nodedata : dealInputData(data.toString())) {
			dataorder++;
			lastdata = findInputDataIndex(dataorder, data.toString());
			errdata = lastdata;
			String objectType = typeConfirm(nodedata, lastdata[0], lastdata[1]);
			Object OperatorClass = loadImpl("com.airwallex.spring.rpn.service.impl." + "RpnOperate" + objectType + "ServiceImpl");
			ros = (RpnOperateService) OperatorClass;
			ros.calculate(nodedata, rpnAllLinkedStack, rpnRealNumberLinkedStatck, lastdata[0], lastdata[1]);
		}
		System.out.println(outputdata(rpnRealNumberLinkedStatck));

	}

}
