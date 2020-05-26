package com.ssafy.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@Autowired
	UserService uService;

	@PostMapping("/login")
	public String login(Model model, @ModelAttribute UserInfo info, HttpSession session) {
		try {
			UserInfo selected = uService.login(info.getUserid());
			session.setAttribute("loginUser", selected);
			return "redirect:/main";// sendredirect			
		} catch (RuntimeException e) {
			logger.error("로그인 실패", e);
			model.addAttribute("message", e.getMessage());
			return "error"; // sendrerdirect ? or forward?
		}
	}
	

	
	@GetMapping("/main")
	public String main(Model model) {
		// 회원 정보를 조사해서 넘겨주기
		try {
			List<UserInfo> selected = uService.selectAll();
			model.addAttribute("users", selected);
			return "main";// forward			
		} catch (RuntimeException e) {
			logger.error("사용자 조회 실패", e);
			model.addAttribute("message", e.getMessage());
			return "error"; // sendrerdirect ? or forward?
		}
	}
	
	@GetMapping("/rest/{data}")
	public @ResponseBody String helloRest(@PathVariable String data) {
		return "이것이 rest "+ data;
	}
}
