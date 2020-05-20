package com.ssafy.day1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	private static Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	@Test
	public void logTest() {
		logger.trace("{} 레벨에서 어떤 값{}가 출력되나?", "trace", 10);
		logger.debug("{} 레벨에서 어떤 값{}가 출력되나?", "debug", true);
		logger.info("{} 레벨에서 어떤 값{}가 출력되나?", "info", "정보");
		logger.warn("{} 레벨에서 어떤 값{}가 출력되나?", "warn", new Object());
		logger.error("{} 레벨에서 어떤 값{}가 출력되나?", "error", 10, true);
		logger.error("예외 발생", new RuntimeException());
	}
}
