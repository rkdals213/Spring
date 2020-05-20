package com.ssafy.day01.model.service;

import java.util.List;

import com.ssafy.day01.model.dto.Product;
import com.ssafy.day01.model.repo.ProductRepo;

public interface ProductService {
	public ProductRepo getRepo();
	public List<Product> selectAll();
	public Product select(String id);
	public int insert(Product product);
	public int update(Product product);
	public int delete(String id);
}
