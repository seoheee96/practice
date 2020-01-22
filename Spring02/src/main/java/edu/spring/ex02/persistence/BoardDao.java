package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Board;

public interface BoardDao {

	List<Board> read();
	Board read(int bno);
	int create(Board board);
	int update(Board board);
	int delete(int bno);
	int update(int bno, int increase);
	
} // end interface BoardDao



