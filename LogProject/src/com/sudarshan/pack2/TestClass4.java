package com.sudarshan.pack2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass4 {
	
	Logger logger = LoggerFactory.getLogger(TestClass4.class);
	
	public void testMethod() throws Exception {
		
		String name = "Sudarshan";
		String system = "Dude";
		Thread.currentThread().setName("TestClass4");
		logger.debug("Hello(TestClass4) {} how are u? I am good {}",name, system);
		//Thread.sleep(10000);
		logger.info("Hello1(TestClass4) {} how are u? I am good {}",name, system);
		//Thread.sleep(10000);
		logger.error("Hello2(TestClass4) {} how are u? I am good {}",name, system);
		
	}

}
