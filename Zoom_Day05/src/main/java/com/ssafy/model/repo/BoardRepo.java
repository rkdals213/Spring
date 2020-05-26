package com.ssafy.model.repo;

import com.ssafy.model.dto.Board;

public interface BoardRepo {
	int insert(Board board);
	
	Board selectDetail(int boardno);
}
