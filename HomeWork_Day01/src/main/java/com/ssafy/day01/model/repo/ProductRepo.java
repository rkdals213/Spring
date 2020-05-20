package com.ssafy.day01.model.repo;

import java.util.List;

import com.ssafy.day01.model.dto.Product;

public interface ProductRepo {
	public List<Product> selectAll();
	public Product select(String id);
	public int insert(Product product);
	public int update(Product product);
	public int delete(String id);
}
