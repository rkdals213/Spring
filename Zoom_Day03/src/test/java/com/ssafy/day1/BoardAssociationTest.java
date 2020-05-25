package com.ssafy.day1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.spring.config.ApplicationConfig;
import com.ssafy.zoom3.model.dto.Board;
import com.ssafy.zoom3.model.dto.UserInfo;
import com.ssafy.zoom3.model.repo.BoardRepo;
import com.ssafy.zoom3.model.repo.UserRepo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BoardAssociationTest {
	
	@Autowired
	BoardRepo bRepo;
	
	@Autowired
	UserRepo uRepo;
	
	@Test
	public void testBoard() {
		Board board = bRepo.selectDetail(1);
		assertThat(board.getUser().getPass() , is("1234"));
	}
	
	@Test
	public void testUser() {
		UserInfo user = uRepo.selectDetail("hong");
		if(user!=null) {
			List<Board> boards = user.getBoards();
			assertThat(boards.size(), is(1));
		}
	}
}
