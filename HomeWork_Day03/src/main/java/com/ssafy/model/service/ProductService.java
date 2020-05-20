package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repo.ProductRepo;

@Controller
public class ProductService {

	@Autowired
	ProductRepo repo;	
	
	@GetMapping("productregist")
	public String showProductRegistForm() {
		return "productinfo";
	}
	@PostMapping("productregist")
	public String productRegist(Model model, @ModelAttribute Product pro) {
//		model.addAttribute("productvalue", pro);
		repo.insert(pro);
		return "home";
	}
	@GetMapping("productinfo")
	public List<Product> showProducts() {
		return repo.select();
	}
}
