package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Board;

// Spring 프레임워크에게 영속 계층 콤포넌트(DAO)임을 알려주는 어노테이션
@Repository
public class BoardDaoImple implements BoardDao {
	// Board 테이블에 대한 SQL 문장들을 찾기 위한 이름 공간(namespace) - mapper.xml
	private static final String NAMESPACE = 
			"edu.spring.ex02.mappers.BoardMapper";
	private static final Logger log =
			LoggerFactory.getLogger(BoardDaoImple.class);

	@Autowired SqlSession sqlSession;
	
	@Override
	public List<Board> read() {
		log.info("read() 호출");
		
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public Board read(int bno) {
		log.info("read(bno={})", bno);
		
		return sqlSession.selectOne(NAMESPACE + ".selectByBno", bno);
	}
	
	@Override
	public int create(Board board) {
		log.info("create({})", board);
		
		return sqlSession.insert(NAMESPACE + ".create", board);
	}
	
	@Override
	public int update(Board board) {
		log.info("update({})", board);
		
		return sqlSession.update(NAMESPACE + ".update", board);
	}
	
	@Override
	public int delete(int bno) {
		log.info("delete(bno={})", bno);
		
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}
	
	@Override
	public int update(int bno, int increase) {
		log.info("update(bno={}, increase={})", bno, increase);
		
		Map<String, Object> params = new HashMap<>();
		params.put("bno", bno);
		params.put("increase", increase);
		
		return sqlSession.update(NAMESPACE + ".updateReplyCnt", params);
	}
} // end class BoardDaoImple





