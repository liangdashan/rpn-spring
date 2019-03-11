package com.airwallex.spring.rpn.service;

import java.util.LinkedList;

import com.airwallex.spring.rpn.exception.RpnException;

public interface RpnOperateService {

	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args)  ;

}
