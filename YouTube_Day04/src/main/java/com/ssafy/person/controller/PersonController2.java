package com.ssafy.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.person.dto.Person;
import com.ssafy.person.service.PersonService;

@RestController //나 컨트롤러!! ---> servlet-context.xml등록
//@RequestMapping("/rest")
public class PersonController2 {
	
	@Autowired
	PersonService service;

//	@RequestMapping(value="/all", method = RequestMethod.GET)
	@GetMapping("/all")
	public List<Person> list(Model m) {		
		return service.findAll();//JSP페이지 포워딩
	} // 전체조회 : http://localhost:8080/person/all + GET
	
	@PostMapping("/reg")
	public String regist(Person p) {		
		int t = service.registry(p);
		if(t==1) return "success";
		else return "fail";
	} // 사람등록 : http://localhost:8080/person/ + POST
	
	
	
	/*
	@RequestMapping(value = "/form", method = RequestMethod.GET) //입력폼보기	
	public String form() {
	  return "person/inputForm";	
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST) //DB입력
	public String formInsert(Person vo) {
		service.registry(vo);
		return "redirect:/list";	
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
	
	*/
	
}








