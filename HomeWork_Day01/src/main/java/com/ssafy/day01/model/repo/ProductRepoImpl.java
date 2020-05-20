package com.ssafy.day01.model.repo;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.day01.model.dto.Product;

@Service("productRepo")
public class ProductRepoImpl implements ProductRepo{
	
	static Logger logger = LoggerFactory.getLogger(ProductRepoImpl.class);
	
	@Autowired
	private DataSource ds = null;
	
	@Autowired
	public ProductRepoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Autowired
	public List<Product> selectAll() {
		logger.debug("Repo의 selectAll");
		return null;
	}

	@Override
	public Product select(String id) {
		logger.debug("Repo의 select");
		return null;
	}

	@Override
	public int insert(Product product) {
		logger.debug("Repo의 insert");
		return 0;
	}

	@Override
	public int update(Product product) {
		logger.debug("Repo의 update");
		return 0;
	}

	@Override
	public int delete(String id) {
		logger.debug("Repo의 delete");
		return 0;
	}

}
