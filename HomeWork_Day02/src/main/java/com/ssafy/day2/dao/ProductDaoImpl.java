package com.ssafy.day2.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.day2.dto.Product;

public class ProductDaoImpl implements ProductDao{

	List<Product> list = null;
	
	public ProductDaoImpl() {
		list = new ArrayList<>();
		list.add(new Product("id1", "name1", 1111, "정보1"));
		list.add(new Product("id2", "name2", 2222, "정보2"));
		list.add(new Product("id3", "name3", 3333, "정보3"));
	}
	
	@Override
	public void insert(Product product) {
		list.add(product);
	}

	@Override
	public List<Product> select() {		
		return this.list;
	}
	
}
