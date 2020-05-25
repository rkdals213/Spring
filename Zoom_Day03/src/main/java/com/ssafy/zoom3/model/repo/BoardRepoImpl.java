package com.ssafy.zoom3.model.repo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.zoom3.model.dto.Board;

@Repository
public class BoardRepoImpl implements BoardRepo {
	
	private static String ns = "com.ssafy.mapper.Board.";
	
	@Autowired
	SqlSessionTemplate temp;
	
	@Override
	public int insert(Board board) {
		return temp.insert(ns+"insert", board);
	}

	@Override
	public Board selectDetail(int boardno) {
		
		return temp.selectOne(ns+"selectDetail", boardno);
	}
	
}
