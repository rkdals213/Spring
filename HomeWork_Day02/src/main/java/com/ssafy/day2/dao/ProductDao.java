package com.ssafy.day2.dao;

import java.util.List;

import com.ssafy.day2.dto.Product;

public interface ProductDao {
	public void insert(Product product);
	public List<Product> select();
}
