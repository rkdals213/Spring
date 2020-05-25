package com.ssafy.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.person.dto.Person;
import com.ssafy.person.service.PersonService;

@Controller //나 컨트롤러!! ---> servlet-context.xml등록
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@RequestMapping("/test")
	public String test() {
		return "hello"; // jsp 페이지 리턴, 포워딩
	}
	
	@RequestMapping("/test2")
	public @ResponseBody String test2() {
		return "hello"; // text(String) 데이터 리턴
	}
	
	@RequestMapping("/test3")
	public @ResponseBody String test3() {
		return "안녕 싸피"; // text(String) 데이터 리턴
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET) //입력폼보기	
	public String form() {
	  return "person/inputForm";	
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST) //DB입력
	public String formInsert(Person vo) {
		service.registry(vo);
		return "redirect:/list";	
	}
	
	
	@RequestMapping("/list")
	public String list(Model m) {		
		m.addAttribute("list",service.findAll());//뷰와 공유할 데이터를 영역에 저장	
		return "person/list";//JSP페이지 포워딩
	}
	
	@RequestMapping(value = "/upform" , method = RequestMethod.GET)//수정폼 보이기
	public String upform(int no, Model m) {
		m.addAttribute("person",service.find(no));
		return "person/editForm";
	}
	
	@RequestMapping(value = "/upform" , method = RequestMethod.POST)//DB수정하기
	public String update(Person vo) {
		service.modify(vo);		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")//DB삭제하기
	public String delete(int no) {
		service.remove(no);
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
   
	
	
	
	/*
	    컨트롤러내의 메소드 : MVC패턴 Servlet클래스의 service,doGet,doPost메소드역할
	    <컨트롤러의 역할>
	    1. 요청분석
	    2. 사용자 입력데이터 얻어오기
	    3. 서비스객체생성,호출
	    4. 데이터 영역저장(뷰와 공유)
	    5. 이동페이지 설정(forward,redirect)	
	 */
	
	@RequestMapping("/m1")  //단순페이지 포워딩 (http://localhost:8080/person/m1 요청시)
	                                                                 //가상경로
	public String m1() { 
	  return "person/m1";   
	}
	//prefix==> "/WEB-INF/views/"+"person/m1" + //suffix==> ".jsp"
    // "/WEB-INF/views/person/m1.jsp"
	
	@RequestMapping("/m2")  //단순페이지 포워딩  (http://localhost:8080/person/m2 요청시)
	public void m2() {}
	//만약 요청URL과 결과JSP경로가 일치한다면 return 생략가능
	// "/WEB-INF/views/m2.jsp"
	
	@RequestMapping("/m3")  //리다이렉트 준비
	public String m3() {
	  return "person/m3";
	}// "/WEB-INF/views/person/m3.jsp"
	
	@RequestMapping("/m4")  //리다이렉트 이동
	public String m4() {
	  return "redirect:/m3";
	}
	
	@RequestMapping("/m5")  
	public String m5(String name) {
	/*
    http://localhost:8080/person/m5?name=gildong
          
        또는
	
	<form action="/person/m5" method=post>
	   <input type=text name=name><br>
	   <input type=submit value=전송>
	</form>
	*/	
		System.out.println(name); //gildong출력
		return "person/m5";
	}
	
	@RequestMapping("/m6")  
	public String m6(String name, int age) {
		/*
    http://localhost:8080/person/m6?name=gildong&age=13
          
        또는
	
	<form action="/person/m6" method=post>
	   <input type=text name=name><br>
	   <input type=text name=age><br>
	   <input type=submit value=전송>
	</form>
		 */	
		System.out.println(name); //gildong출력
		System.out.println(age); //13출력
		return "person/m6";
	}
	
	@RequestMapping("/m7")  
	public String m7(Person p) {
		/*
    http://localhost:8080/person/m7?name=gildong&age=13
          
        또는
	
	<form action="/person/m7" method=post>
	   <input type=text name=name><br>
	   <input type=text name=age><br>
	   <input type=submit value=전송>
	</form>
	
	스프링프레임워크에서는   Person p = new Person();
	   p.setName(request.getParameter("name"));
	   p.setAge(Integer.parseInt(request.getParameter("age"))); 코드생성	
		 */	
		System.out.println(p.getName()); //gildong출력
		System.out.println(p.getAge()); //13출력
		return "person/m7";
	}
	
	@RequestMapping("/m8")  
	public String m8(int no, HttpServletRequest request) {
				
		request.setAttribute("person",service.find(no));
		
		return "person/m8";
	}
	
	@RequestMapping("/m8_2")  
	public String m8(int no, Model model) {
				
		model.addAttribute("person",service.find(no));
		
		return "person/m8";
	}
	
	@RequestMapping("/m9")  
	public String m9() {		
		return "person/m9";
	}
	
	@RequestMapping("/m10")  
	public String m10(int no, HttpSession session) {
		
		session.setAttribute("person",service.find(no));
		
		return "redirect:/m9";
	}
	
}








