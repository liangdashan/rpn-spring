package com.airwallex.spring.rpn.aspect;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.airwallex.spring.rpn.controller.RpnController;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath*:rpnaop.xml") 
public class RpnAspectTest {
	
	@Autowired
	RpnController RpnController;
	
	public static final LinkedList rpnAllLinkedStack = new LinkedList();
	public static final LinkedList rpnRealNumberLinkedStatck = new LinkedList();
	@Test
	public void test() {
		
		RpnController.RpnOperator("*" , rpnAllLinkedStack , rpnRealNumberLinkedStatck);
	}

}
