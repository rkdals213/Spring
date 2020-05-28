package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

import io.swagger.annotations.Api;

@RestController // rest 전용
@RequestMapping("/api")
@Api(value="SSAFY")
public class ProductController {

	static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService pService;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable String id) {
		ResponseEntity<Map<String, Object>> entity = null;
		logger.debug("------------------------select");
		try {
			Product product = pService.select(id);
			entity = handleSuccess(product);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@GetMapping("/product")
	public ResponseEntity<Map<String, Object>> selectAll() {
		ResponseEntity<Map<String, Object>> entity = null;
		logger.debug("------------------------selectAll");
		try {
			List<Product> product = pService.selectAll();
			entity = handleSuccess(product);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@PostMapping("/product")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Product product){
		ResponseEntity<Map<String, Object>> entity = null;
		logger.debug("------------------------insert");
		try {
			int result = pService.insert(product);
			entity = handleSuccess(product);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@PutMapping("/product")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Product product){
		ResponseEntity<Map<String, Object>> entity = null;
		logger.debug("------------------------update");
		try {
			int result = pService.update(product);
			entity = handleSuccess(product);
		} catch (Exception e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String id){
		ResponseEntity<Map<String, Object>> entity = null;
		logger.debug("------------------------delete");
		try {
			int result = pService.delete(id);
			entity = handleSuccess(id);
		} catch (Exception e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	private ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	private ResponseEntity<Map<String, Object>> handleException(Exception e) {
		logger.error("예외 발생", e);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
