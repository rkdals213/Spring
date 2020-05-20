package com.ssafy.day1.model.service;

import com.ssafy.day1.model.dto.Board;

public interface BoardService {
	Board findBoard(int boardNo);
	void writeBoard(Board board);
}
