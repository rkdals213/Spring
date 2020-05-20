package com.ssafy.day1.model.repo;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.day1.model.dto.Board;
// POJO - 스프링에서는 이걸 Bean으로 관리
@Repository // 묵시적인 Bean의 생성 : Bean의 이름은 기본적으로 클래스 첫글자를 소문자로
public class BoardRepoImpl implements BoardRepo{
	// 로거
	static Logger logger = LoggerFactory.getLogger(BoardRepoImpl.class);
	
	// DB에 접속하려면 DataSource가 필요해
	@Autowired
	DataSource ds = null; // new DriverManagerDataSource(); 직접적인 객체 사용은 종속을 유발
	
	// 생성자를 통해서 DataSource를 주입받아보자
	
	public BoardRepoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public Board findBoard(int boardNo) {
		logger.trace("boardNo : {}", boardNo);
		return null;
	}

	@Override
	public void writeBoard(Board board) {
		//logger.trace("board" + board);
		logger.trace("board 확인 : {}", board);
	}

}
