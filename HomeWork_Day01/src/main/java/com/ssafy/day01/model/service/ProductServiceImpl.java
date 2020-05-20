package com.ssafy.day01.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.day01.model.dto.Product;
import com.ssafy.day01.model.repo.ProductRepo;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private ProductRepo productRepo;
	@Autowired
	public ProductRepo getRepo() {
		logger.debug("Service의 getRepo");
		return productRepo;
	}

	@Autowired
	public List<Product> selectAll() {
		logger.debug("Service의 selectAll");
		return null;
	}

	@Override
	public Product select(String id) {
		logger.debug("Service의 select");
		return null;
	}

	@Override
	public int insert(Product product) {
		logger.debug("Service의 insert");
		return 0;
	}

	@Override
	public int update(Product product) {
		logger.debug("Service의 update");
		return 0;
	}

	@Override
	public int delete(String id) {
		logger.debug("Service의 delete");
		return 0;
	}

}
