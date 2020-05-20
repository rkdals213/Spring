package com.ssafy.day01.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.day01.config.ProductConfig;
import com.ssafy.day01.config.ProductConfig2;
import com.ssafy.day01.model.repo.ProductRepo;
import com.ssafy.day01.model.service.ProductService;
import com.ssafy.day01.model.service.ProductServiceImpl;

public class ProductClient {
	static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ProductConfig.class);
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(ProductConfig2.class);
		
		String [] beanNames = ctx.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			logger.debug(beanName);
		}
		
		ProductService service1 = ctx.getBean(ProductService.class);
		ProductService service2 = (ProductService) ctx.getBean("productService");
		ProductService service3 = ctx.getBean("productService", ProductService.class);
		
		logger.debug("Bean의 동일성 : {}, {}", service1==service2, service2==service3);
		
		service1.delete(null);
		service1.update(null);
		service1.insert(null);
		service1.select(null);
		
		ProductRepo repo = ctx.getBean(ProductRepo.class);
		repo.delete(null);
		repo.update(null);
		repo.insert(null);
		repo.select(null);
		
	}
}
