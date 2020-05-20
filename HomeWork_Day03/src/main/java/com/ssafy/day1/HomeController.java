package com.ssafy.day1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repo.ProductRepoImpl;
import com.ssafy.model.service.ProductService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@Autowired
	ProductService service;
	
	
	@GetMapping("productregist")
	public String showProductRegistForm() {
		return "productinfo";
	}
	
	@PostMapping("productregist")
	public String productRegist(Model model, @ModelAttribute Product pro) {
		try {
			return service.productRegist(model, pro);
		} catch (Exception e) {
			return "error";
		}
		
	}
	
	@GetMapping("productinfo")
	public String showProducts(Model model) {
		List<Product> list = new ArrayList<>();
		try {
			list = service.showProducts();
			model.addAttribute("productinfo", list);
			return "productlist";
		} catch (Exception e) {
			logger.error("로그인 실패", e);
			model.addAttribute(e.getMessage());
			return "error"; 
		}
	}	
}
