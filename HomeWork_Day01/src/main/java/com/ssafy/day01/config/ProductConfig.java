package com.ssafy.day01.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ssafy.day01.model.repo.ProductRepo;
import com.ssafy.day01.model.repo.ProductRepoImpl;
import com.ssafy.day01.model.service.ProductService;
import com.ssafy.day01.model.service.ProductServiceImpl;

@Configuration
public class ProductConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		return ds;
	}
	
	@Bean
	public ProductRepo productRepo() {
		ProductRepo repo = new ProductRepoImpl(dataSource());
		return repo;
	}
	
	@Bean
	public ProductService productService() {
		ProductService service = new ProductServiceImpl();
		return service;
	}
	
}
