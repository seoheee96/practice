package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.persistence.BoardDao;
import edu.spring.ex02.persistence.ReplyDao;
import edu.spring.ex02.persistence.UserDao;

@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger log =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired private ReplyDao replyDao;
	@Autowired private BoardDao boardDao;
	@Autowired private UserDao userDao;

	@Override
	public int create(Reply reply) {
		log.info("create({})", reply);
		// 댓글 추가(insert) 기능
		// 1) 댓글 테이블에 insert
		int result = replyDao.create(reply);
		// 2) 게시판 테이블의 reply_cnt 컬럼의 값을 1 증가
		result = boardDao.update(reply.getBno(), 1);
		// 3) 댓글을 작성한 사용자에게 포인트 5점을 업데이트
		result = userDao.update(reply.getUserid(), 5);
		
		return result;
	}

	@Override
	public List<Reply> read(int bno) {
		log.info("read(bno={})", bno);
		
		return replyDao.read(bno);
	}

	@Override
	public int update(Reply reply) {
		log.info("update({})", reply);
		
		return replyDao.update(reply);
	}

	@Override
	public int delete(int rno) {
		log.info("delete(rno={})", rno);
		// 댓글 삭제 기능
		// 1) 삭제할 댓글(rno)이 달려 있는 게시글의 번호(bno)를 먼저 찾아둠.
		Integer bno = replyDao.readBno(rno);
		// 2) 댓글 삭제
		int result = replyDao.delete(rno);
		// 3) 댓글 삭제가 성공하면, 게시판 테이블에서 reply_cnt 컬럼의 값을 1 감소
		result = boardDao.update(bno, -1);
		
		return result;
	}

} // end class ReplyServiceImple








