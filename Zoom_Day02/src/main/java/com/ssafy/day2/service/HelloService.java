package com.ssafy.day2.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	//repo 호출해서 결과 반환해야하지만 간단하게 만듬
	public String sayHello(String name) {
		return "안녕" +name;
	}
}
