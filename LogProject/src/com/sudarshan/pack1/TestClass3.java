package com.sudarshan.pack1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass3 {
	
	Logger logger = LoggerFactory.getLogger(TestClass3.class);
	
	public void testMethod() throws Exception {
		
		String name = "Sudarshan";
		String system = "Dude";
		Thread.currentThread().setName("TestClass3");
		logger.debug("Hello(TestClass3) {} how are u? I am good {}",name, system);
		//Thread.sleep(10000);
		logger.info("Hello1(TestClass3) {} how are u? I am good {}",name, system);
		//Thread.sleep(10000);
		logger.error("Hello2(TestClass3) {} how are u? I am good {}",name, system);
		
	}

}
