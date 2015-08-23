package com.sudarshan.pack1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.sudarshan.pack2.TestClass4;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class TestClass1 {

	private Logger logger = LoggerFactory.getLogger(TestClass1.class);
	private LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

	public static void main(String[] args) throws Exception {
		TestClass1 tc1 = new TestClass1();
		
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(tc1.lc);
			tc1.lc.reset();
			//configurator.doConfigure("E:/Spring/Spring Security/Eclipse Workspace/LogProject/logback.xml");
			//configurator.doConfigure("D:/GitRepositories/LogProject/rollingFilelogback.xml");
			configurator.doConfigure("D:/GitRepositories/LogProject/siftlogback.xml");
			MDC.put("ifsc", "ABNK0000001");
			//tc1.logger.debug("hello");
			//MDC.remove("ifsc");
		} catch (JoranException je) {
			je.printStackTrace();
		}
		// After we've called Joran, let's print information about the
		// internal status of logback
		StatusPrinter.print(tc1.lc);

		String name = "Sudarshan";
		String system = "Dude";
		Thread.currentThread().setName("TestClass1");
		for(int i=0;i<1000;i++) {
			tc1.logger.debug("Hello(TestClass1) {} how are u? I am good {}",name, system);
			//Thread.sleep(10000);
			tc1.logger.info("Hello1(TestClass1) {} how are u? I am good {}",name, system);
			//Thread.sleep(10000);
			tc1.logger.error("Hello2(TestClass1) {} how are u? I am good {}",name, system);

			new TestClass3().testMethod();
			new TestClass4().testMethod();
		}
	}

}
