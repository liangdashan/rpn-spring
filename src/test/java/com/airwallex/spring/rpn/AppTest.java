package com.airwallex.spring.rpn;

import java.io.Reader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath*:rpnaop.xml")
public class AppTest {

	@Autowired
	DaemonAppTest DA;
	
	@Test
	public void test() {
		DA.rpngo();
	}
}
