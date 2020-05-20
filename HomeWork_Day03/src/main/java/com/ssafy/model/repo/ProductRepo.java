package com.ssafy.model.repo;

import java.util.List;

import com.ssafy.model.dto.Product;


public interface ProductRepo {
	public int insert(Product product);
	public List<Product> select();
}
