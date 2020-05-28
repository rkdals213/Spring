package com.ssafy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repo.ProductRepo;

@SpringBootTest
class HomeWorkDay06ApplicationTests {

	@Autowired
	ProductRepo repo;
	
	@Test
	@Transactional
	void selectAllTest() {
		List<Product> list = repo.selectAll();
		for (Product product : list) {
			System.out.println(product);
		}
	}
	
	@Test
	@Transactional
	void selectTest() {
		Product p = repo.select("tv");
		System.out.println(p);
	}
	
	@Test
	@Transactional
	void insertTest() {
		int result = repo.insert(new Product("test", "test", 99999, "test"));
		System.out.println(result);
	}
	
	@Test
	@Transactional
	void updateTest() {
		int result = repo.update(new Product("tv", "test", 99999, "test"));
		System.out.println(result);
	}
	
	@Test
	@Transactional
	void deleteTest() {
		int result = repo.delete("tv");
		System.out.println(result);
	}

}
