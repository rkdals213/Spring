package com.ssafy.day3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.day3.dto.Guest;
import com.ssafy.day3.repository.GuestDAO;

@Controller
@RequestMapping("/guest")
public class GuestController {
    
	@Autowired
	private GuestDAO dao;
	
	
//	@RequestMapping(value = "/form", method = RequestMethod.GET) //입력폼보기
	@GetMapping("/form")
	public String form() {
	  return "guest/inputForm";	
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST) //DB입력
//	@PostMapping("/from")
	public String formInsert(Guest vo) {
		dao.insert(vo);
			
		return "redirect:/guest/list";	
	}
	
//	@RequestMapping("list")//리스트 보여주기
//	public String list(Model m) {		
//		m.addAttribute("list",dao.selectAll());//뷰와 공유할 데이터를 영역에 저장		
//		return "guest/list";//JSP페이지 포워딩
//	}
	
	@RequestMapping("list")//페이징된 리스트 보여주기
	//public String list(Model m, int page, int limit) {
	//	int page = Integer.parseInt(request.getParameter("page"));
	
	public String list(Model m, Integer page, Integer limit) {
		System.out.println("page>>>"+ page);
		//기본값: 페이지,limit
		int pageNo,limitNo;
		
		if(page==null) pageNo=1;
		else  		pageNo=page;
		
		if(limit==null) limitNo=10;
		else            limitNo=limit;
		
		m.addAttribute("page",pageNo);
		m.addAttribute("limit",limitNo);
		
		m.addAttribute("list",dao.selectPage(pageNo,limitNo));//뷰와 공유할 데이터를 영역에 저장
		
		
		return "guest/list";//JSP페이지 포워딩
	}
	
	@RequestMapping(value = "/upform" , method = RequestMethod.GET)//수정폼 보이기
	public String upform(int no, Model m) {
		m.addAttribute("guest",dao.select(no));
		
		return "guest/editForm";
	}
	
	@RequestMapping(value = "/upform" , method = RequestMethod.POST)//DB수정하기
	public String update(Guest vo) {
		System.out.println("수정vo>>>"+vo);
		dao.update(vo);		
		return "redirect:/guest/list";
	}
	
	@RequestMapping("/delete")//DB삭제하기
	public String delete(int no) {
		dao.delete(no);
		return "redirect:/guest/list";
	}
	
}

