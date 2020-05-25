package com.ssafy.zoom3.model.repo;

import com.ssafy.zoom3.model.dto.Board;

public interface BoardRepo {
	int insert(Board board);
	
	Board selectDetail(int boardno);
}
