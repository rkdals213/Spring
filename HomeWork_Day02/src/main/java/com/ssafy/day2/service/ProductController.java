package com.ssafy.day2.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.day2.dao.ProductDaoImpl;
import com.ssafy.day2.dto.Product;

@Controller
public class ProductController {
	static ProductDaoImpl dao = new ProductDaoImpl();
	@GetMapping("productregist")
	public String showProductRegistForm() {
		return "productinfo";
	}
	@PostMapping("productregist")
	public String productRegist(Model model, @ModelAttribute Product pro) {
//		model.addAttribute("productvalue", pro);
		dao.insert(pro);
		return "productinfo";
	}
	@GetMapping("productinfo")
	public String showProducts(Model model) {
		List<Product> list = dao.select();
		for (Product product : list) {
			System.out.println(product);
		}
		model.addAttribute("productinfo", list);
		return "productlist";
	}
}
