package com.ssafy.day1.model.repo;

import com.ssafy.day1.model.dto.Board;

public interface BoardRepo {
	Board findBoard(int boardNo);
	void writeBoard(Board board);
}
