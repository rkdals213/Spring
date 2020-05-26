package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repo.ProductRepo;

@Controller
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo repo;	
	
	@Override
	public int insert(Product product) {
		return repo.insert(product);
	}
	@Override
	public List<Product> selectAll() {
		return repo.selectAll();
	}
	@Override
	public int update(Product product) {
		return repo.update(product);
	}
	@Override
	public int delete(String id) {
		return repo.delete(id);
	}
	@Override
	public Product select(String id) {
		return repo.select(id);
	}
	
	
}
