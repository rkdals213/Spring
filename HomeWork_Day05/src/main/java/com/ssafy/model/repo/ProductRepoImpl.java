package com.ssafy.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;

@Repository
public class ProductRepoImpl implements ProductRepo{
	private static String ns = "com.ssafy.mapper.Product.";

	@Autowired
	SqlSessionTemplate template;
	
	@Override
	public int insert(Product product) {
		return template.insert(ns+"insert", product);
	}

	@Override
	public List<Product> selectAll() {		
		return template.selectList(ns+"selectAll");
	}

	@Override
	public int update(Product product) {
		return template.update(ns+"update", product);
	}

	@Override
	public int delete(String id) {
		return template.delete(ns+"delete", id);
	}

	@Override
	public Product select(String id) {
		return template.selectOne(ns+"select", id);
	}
	
	
}
