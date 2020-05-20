package com.ssafy.day1.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.day1.config.BoardConfig;
import com.ssafy.day1.config.BoardConfig2;
import com.ssafy.day1.model.service.BoardService;

public class BoardClient {
	static Logger logger = LoggerFactory.getLogger(BoardClient.class);
	
	public static void main(String[] args) {
		// container 생성
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(BoardConfig.class);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BoardConfig2.class);
		
		// 현재까지 생성된 Bean의 목록을 알아보자
		String [] beanNames = ctx.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			logger.debug("bean : {}", beanName);
		}
		
		// 본격적으로 Bean을 사용해보자
		BoardService service1 = ctx.getBean(BoardService.class);
		BoardService service2 = (BoardService) ctx.getBean("boardService");
		BoardService service3 = ctx.getBean("boardService", BoardService.class);
		
		logger.debug("Bean의 동일성 : {}, {}", service1==service2, service2==service3);
		
		service1.findBoard(1);
	}
}
