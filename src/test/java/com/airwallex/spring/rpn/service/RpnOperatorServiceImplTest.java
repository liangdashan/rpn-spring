package com.airwallex.spring.rpn.service;

import static com.airwallex.spring.rpn.DaemonApp.rpnRealNumberLinkedStatck;
import static com.airwallex.spring.rpn.utils.RpnCalculate.outputdata;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.airwallex.spring.rpn.service.impl.RpnOperateClearServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperateDivServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperateMinusServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperateMultiServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperateNumberServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperatePlusServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperateSqrtServiceImpl;
import com.airwallex.spring.rpn.service.impl.RpnOperateUndoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath*:rpnaop.xml") 
public class RpnOperatorServiceImplTest {

	@Autowired
	RpnOperateMultiServiceImpl muli;
	
	@Autowired
	RpnOperateDivServiceImpl div;
	
	@Autowired
	RpnOperateClearServiceImpl clear;	
	
	@Autowired
	RpnOperateNumberServiceImpl number;
	
	@Autowired
	RpnOperatePlusServiceImpl plus;
	
	@Autowired
	RpnOperateSqrtServiceImpl sqrt;
	
	@Autowired
	RpnOperateMinusServiceImpl minus;
	
	@Autowired
	RpnOperateUndoServiceImpl undo;
	
	
	public static final LinkedList rpnAllLinkedStack = new LinkedList();
	public static final LinkedList rpnRealNumberLinkedStatck = new LinkedList();
	
	@Before
	public void add(){
		rpnAllLinkedStack.addLast("1");
		rpnRealNumberLinkedStatck.addLast("1");
		rpnAllLinkedStack.addLast("0");
		rpnRealNumberLinkedStatck.addLast("0");
	}
	
	@Test
	public void testmutl() {
		muli.calculate("", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	
	@Test
	public void testdiv() {
		div.calculate("", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	
	@Test
	public void testplus() {
		plus.calculate("", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	
	@Test
	public void testminus() {
		minus.calculate("", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	
	@Test
	public void testclear() {
		clear.calculate("", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	
	@Test
	public void testundo() {
		undo.calculate("", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	
	@Test
	public void testnumber() {
		number.calculate("55555", rpnAllLinkedStack, rpnRealNumberLinkedStatck);
		//查看堆栈情况
		System.out.println(outputdata(rpnAllLinkedStack));
		System.out.println(outputdata(rpnRealNumberLinkedStatck));
	}
	


}
