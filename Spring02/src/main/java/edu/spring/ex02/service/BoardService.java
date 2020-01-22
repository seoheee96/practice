package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.Board;

public interface BoardService {

	List<Board> read();
	Board read(int bno);
	int create(Board board);
	int update(Board board);
	int delete(int bno);
	
} // end interface BoardService






