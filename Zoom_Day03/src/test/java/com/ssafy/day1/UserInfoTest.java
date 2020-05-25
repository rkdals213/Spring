package com.ssafy.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.spring.config.ApplicationConfig;
import com.ssafy.zoom3.model.dto.UserInfo;
import com.ssafy.zoom3.model.repo.UserRepo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserInfoTest {

	@Autowired
	UserRepo repo;
	
	@Test
	public void selectTest() {
		UserInfo src = new UserInfo("hong", "1234");
		UserInfo selected = repo.select(src.getUserid());
		
		assertThat(src.getUserid(), is(selected.getUserid()));
	}
	
}
