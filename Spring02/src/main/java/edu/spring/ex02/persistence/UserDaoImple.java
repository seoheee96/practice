package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.User;
import edu.spring.ex02.mappers.UserMapper;

@Repository
public class UserDaoImple implements UserDao {
	private static final String NAMESPACE =
			"edu.spring.ex02.mappers.UserMapper";
	
	private static final Logger log =
			LoggerFactory.getLogger(UserDaoImple.class);
	
	// user-mapper.xml에 정의한 SQL 문장들을 실행하기 위해서
	@Autowired private SqlSession sqlSession;
	
	// UserMapper 인터페이스를 구현한 객체를 주입
	@Autowired private UserMapper mapper;

	@Override
	public int update(String userid, int points) {
		log.info("update(userid={}, points={})", userid, points);
		
		Map<String, Object> params = new HashMap<>();
		params.put("userid", userid);
		params.put("points", points);
		int result = sqlSession.update(NAMESPACE + ".updatePoints", params);
		
		return result;
	}
	
	@Override
	public User signinCheck(User user) {
		log.info("signinCheck({})", user);
		
		return mapper.signinCheck(user);
	}
	
} // end class UserDaoImple





