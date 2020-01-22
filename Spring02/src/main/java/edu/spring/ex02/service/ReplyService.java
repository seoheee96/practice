package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.Reply;

public interface ReplyService {

	int create(Reply reply);
	List<Reply> read(int bno);
	int update(Reply reply);
	int delete(int rno);
	
} // end interface ReplyService
