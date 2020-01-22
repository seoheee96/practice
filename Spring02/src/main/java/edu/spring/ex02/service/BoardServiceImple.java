package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.persistence.BoardDao;
import edu.spring.ex02.persistence.UserDao;

// Spring 프레임워크에게 서비스(비즈니스) 계층의 콤포넌트임을 설정
// root-context.xml 파일에서 <context:component-scan>의 대상이 됨.
@Service
public class BoardServiceImple implements BoardService {
	
	private static final Logger log =
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	// Spring 프레임워크에서 bean으로 관리하고 있는 객체를 주입(inject)받음
	@Autowired private BoardDao boardDao;
	@Autowired private UserDao userDao;
	
	@Override
	public List<Board> read() {
		log.info("read()");
		
		return boardDao.read();
	}

	@Override
	public Board read(int bno) {
		log.info("read(bno={})", bno);
		
		return boardDao.read(bno);
	}

	@Override
	public int create(Board board) {
		log.info("create({})", board);
		
		// DB의 boards 테이블에 새 글 내용을 insert
		int result = boardDao.create(board);
		// boards 테이블에 insert가 성공한 후에는 
		// users 테이블에서 points 컬럼의 값을 수정(update)
		result = userDao.update(board.getUserid(), 10);
		
		return result;
	}

	@Override
	public int update(Board board) {
		log.info("update({})", board);
		
		return boardDao.update(board);
	}

	@Override
	public int delete(int bno) {
		log.info("delete(bno={})", bno);
		
		return boardDao.delete(bno);
	}

} // end class BoardServiceImple





