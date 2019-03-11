package com.airwallex.spring.rpn.aspect;

import com.airwallex.spring.rpn.exception.RpnException;

import static com.airwallex.spring.rpn.utils.RpnCalculate.outputdata;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import static com.airwallex.spring.rpn.DaemonApp.rpnRealNumberLinkedStatck;
import static com.airwallex.spring.rpn.DaemonApp.errdata;

/**
 * 切面
 */
public class RpnExceptionHandler {

	public String handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint) {
		String exceptionData = "";
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			exceptionData = handlerException(e);
			System.out.println(exceptionData);
			System.out.println(outputdata(rpnRealNumberLinkedStatck));
			if (errdata.length > 1) {
				System.out.println("(" + errdata[1] + ")  were not pushed on to the stack due to the previous error");
			}
		}
		return exceptionData;
	}

	/**
	 * 这个是判断异常的类型
	 * 
	 * @param throwable
	 * @return
	 */
	private String handlerException(Throwable throwable) {
		String throwMessage = "";
		if (throwable instanceof Exception || throwable instanceof IllegalArgumentException) {
			throwMessage = throwable.getMessage();
		} else {
			throwMessage = "系统异常";
		}
		return throwMessage;

	}
}
