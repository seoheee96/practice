package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Reply;

@Repository
public class ReplyDaoImple implements ReplyDao {
	private static final String NAMESPACE = 
			"edu.spring.ex02.mappers.ReplyMapper";
	
	private static final Logger log =
			LoggerFactory.getLogger(ReplyDaoImple.class);
	
	@Autowired private SqlSession sqlSession;

	@Override
	public int create(Reply reply) {
		log.info("create({})", reply);
		
		return sqlSession.insert(NAMESPACE + ".create", reply);
	}

	@Override
	public List<Reply> read(int bno) {
		log.info("read(bno={})", bno);
		
		return sqlSession.selectList(NAMESPACE + ".readByBno", bno);
	}
	
	@Override
	public int update(Reply reply) {
		log.info("update({})", reply);
		
		return sqlSession.update(NAMESPACE + ".updateRtext", reply);
	}
	
	@Override
	public int delete(int rno) {
		log.info("delete(rno={})", rno);
		
		return sqlSession.delete(NAMESPACE + ".delete", rno);
	}
	
	@Override
	public Integer readBno(int rno) {
		log.info("readBno(rno={})", rno);
		
		return sqlSession.selectOne(NAMESPACE + ".readBno", rno);
	}
	
} // end class ReplyDaoImple



