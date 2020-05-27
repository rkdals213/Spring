package com.ssafy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.repo.UserRepo;
import com.ssafy.model.service.UserService;

@SpringBootTest
public class ServiceTest {
	@Autowired
	UserService uService;
	
	@Autowired
	UserRepo uRepo;
	
	@Test
	@Transactional
	public void registTest() {
		UserInfo user = new UserInfo("hong6", "1234");
		uService.regist(user);
		
	}
	
	@Test
	@Transactional
	public void registRepo() {
		UserInfo user = new UserInfo("hong5", "1234");
		uRepo.insert(user);
		
	}
}
