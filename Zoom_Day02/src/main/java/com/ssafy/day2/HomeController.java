package com.ssafy.day2;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.day2.dto.User;
import com.ssafy.day2.service.HelloService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HelloService service;
	
	@RequestMapping("hi")
	public String hi(String name, Model model) {
		//컨트롤러의 역할
		//0. 파라미터 확인
		//1. 모델 연동
		System.out.println(name);
		String returnValue = service.sayHello(name);
		//2. 뷰 연결 1단계 -attribute 설정(request 영역에다가)
		model.addAttribute("myvalue",returnValue);
		//3. 뷰페이지 반환
		return "home";
	}
	
	@PostMapping("get")
	public String getRequest(Model model) {
		model.addAttribute("myvalue","get으로 호출됨..");
		return "home";
	}
	@GetMapping(value="param",params="name")
	public String paramTest(Model model) {
		model.addAttribute("myvalue", "paramTest");
		return "home";
	}
	@GetMapping("add")
	public String addTest(Model model, @RequestParam int a, @RequestParam int b) {
		model.addAttribute("myvalue", a+b);
		return "home";
	}

	@GetMapping("multi")
	public String multiParam(Model model, @RequestParam ArrayList<String> params) {
		model.addAttribute("myvalue", params);
		return "home";
	}

	@GetMapping("user")
	public String userTest(Model model, @ModelAttribute User user) {
		model.addAttribute("myvalue",user);
		return "home";
	}
	@GetMapping("session")
	public String sessionTest(Model model, HttpSession session, HttpServletRequest request) {
		session.setAttribute("myvalue", "session에 담긴 값:"+request.getContextPath());
		
		return "home";
	}
	@GetMapping("userregist")
	public String showUserRegistForm() {
		return "userinfo";
	}
	@PostMapping("userregist")
	public String userRegist(Model model, @ModelAttribute User user) {
		model.addAttribute("myvalue", "등록할 사용자 정보: "+user);
		return "home";
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
