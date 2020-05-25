package com.ssafy.day1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repo.ProductRepo;
import com.ssafy.spring.config.ApplicationConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class LogTest {
	private static Logger logger = LoggerFactory.getLogger(LogTest.class);
		
	@Autowired
	ProductRepo repo;
	
	@Test
	public void selectAllTest() {
		List<Product> list = new ArrayList<>();
		list = repo.selectAll();
		assertThat(list.size(), is(2));
	}
	
	@Test
	public void insertTest() {
		repo.insert(new Product("aircon", "에어콘", 2000, "시워언해"));
	}
	
	@Test
	public void updateTest() {
		repo.update(new Product("aircon", "에어콘", 3000, "시워언해"));
	}
}
