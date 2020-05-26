package com.ssafy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.repo.UserRepo;

@SpringBootTest
class ZoomDay05ApplicationTests {

	@Autowired
	UserRepo uRepo;
	
	@Test
	void contextLoads() {
		String userid = "hong";
		List<UserInfo> selected = uRepo.selectIf(userid);
		assertThat(selected.size(), is(1));
		
		userid=null;
		selected = uRepo.selectIf(userid);
		assertThat(selected.size() > 1, is(true));
		
	}
	
	@Test
	void selectSomeTest() {
		List<String> userIds = Arrays.asList("hong", "jang", "lim");
		Map<String, Object> params = new HashMap<>();
		params.put("users", userIds);
		List<UserInfo> users = uRepo.selectSome(params);
		assertThat(users.size() > 1, is(true));
		
	}

}
