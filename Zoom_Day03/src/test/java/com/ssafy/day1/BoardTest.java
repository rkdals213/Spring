package com.ssafy.day1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.spring.config.ApplicationConfig;
import com.ssafy.zoom3.model.dto.Board;
import com.ssafy.zoom3.model.repo.BoardRepo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BoardTest {
	
	static Logger logger = LoggerFactory.getLogger(BoardTest.class);
	
	@Autowired
	BoardRepo repo;
	
	@Test
	public void selectTest() {
		Board board = new Board(-1, "hong", "이거 들어가는거 맞아용???");
		int result = repo.insert(board);
		assertThat(result, is(1));
		logger.debug("board : {}", board);
	}
}
