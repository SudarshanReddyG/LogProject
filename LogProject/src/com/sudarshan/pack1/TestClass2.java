package com.sudarshan.pack1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass2 {
	
	private static Logger logger = LoggerFactory.getLogger(TestClass2.class);

	public static void main(String[] args) throws Exception {
		String name = "Sudarshan";
		String system = "Dude";
		Thread.currentThread().setName("TestClass2");
		logger.debug("Hello(TestClass2) {} how are u? I am good {}",name, system);
		//Thread.sleep(10000);
		logger.info("Hello1(TestClass2) {} how are u? I am good {}",name, system);
		//Thread.sleep(10000);
		logger.error("Hello2(TestClass2) {} how are u? I am good {}",name, system);
	}
}
