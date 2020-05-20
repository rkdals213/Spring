package com.ssafy.day1.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssafy.day1.model.dto.Board;
import com.ssafy.day1.model.repo.BoardRepo;

// POJO
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	BoardRepo bRepo;
	
	public BoardServiceImpl() {
		logger.trace("BoardServiceImple 생성자 호출됨");
	}
	
	@Autowired
	public void setBoardRepo(BoardRepo repo) {
		logger.trace("repo 할당됨");
		this.bRepo = repo;
	}

	@Override
	public Board findBoard(int boardNo) {
		logger.trace("boardNo : " + boardNo);
		return bRepo.findBoard(boardNo);
	}

	@Override
	public void writeBoard(Board board) {
		logger.trace("board : {}", board);
		bRepo.writeBoard(board);
	}

}
