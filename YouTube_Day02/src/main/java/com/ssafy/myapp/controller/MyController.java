package com.ssafy.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myapp.domain.Person;

@Controller
public class MyController {
	
	
	/*
	 * <컨트롤러 코드>
	 * 1. 요청분석
	 * 2. 사용자 입력데이터 얻기
	 * 3. 모델(DAO) 호출
	 * 4. 데이터 영역 저장
	 * 5. 마지막 : 페이지 설정
	 */
	@RequestMapping("killcorona.do") // URL 요청
	void m1() { //  메소느명은 중요하지 않음
		// 메소드 한개는 서블릿의 service메소드 한개와 같다
		System.out.println("코로나 박멸");
	}
	
	@RequestMapping("input")
	void input() {
		System.out.println("입력페이지 요청...");
		
//		return "input";  // 포워드 이동
	}	// 리턴 : 페이지 이동과 관련된 값을 전달 (만약 리턴값이 없다면 요청URL이 리턴의 역할을 함)
	
	
	@RequestMapping("input2")
	String input2() {
		return "home";  // 포워드 이동
	}	
	
//	@RequestMapping("result")
//	void input3(String username, int age) { // 변수명은 HTML의 속성값과 일치해야함
//		// String name = request.getP("username"); request.setA("key", name); forward();
//		// int age = request.getP("age"); request.setA("key", age); forward();
//		System.out.println(username);
//		System.out.println(age);
//	}	
//	
	
	@RequestMapping("result")
	String input4(Person p, HttpSession session, HttpServletRequest request, Model model) {
		// Person p = new Person(); p.setUsername(request.getP("username"))
//		session.setAttribute(name, value);
//		request.setAttribute(name, o);
		// Model은  request와 비슷
		
//		model.addAttribute("pe", p);
		model.addAttribute(p);
		
		return "result";  // 포워드 이동
	}	
	
	// 리다이렉트 이동
	@RequestMapping("/ssafy")
	String input5() {
		return "redirect:/three"; // redirect == client / 접근 불가
	}
	
	@RequestMapping("/three")
	String input7() {
		return "good"; // redirect == client / 접근 불가
	}
}
