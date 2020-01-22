package edu.spring.ex02;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.domain.User;
import edu.spring.ex02.persistence.BoardDao;
import edu.spring.ex02.persistence.ReplyDao;
import edu.spring.ex02.persistence.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
		)
@WebAppConfiguration
public class DaoTest {
	private static final Logger log =
			LoggerFactory.getLogger(DaoTest.class);
	
	@Autowired private BoardDao boardDao;
	@Autowired private ReplyDao replyDao;
	@Autowired private UserDao userDao;

	@Test
	public void doTest() {
		User user = userDao.signinCheck(new User("admin", "admin1234", null, 0));
		assertNotNull(user);
		
		user = userDao.signinCheck(new User("admin", "admin", null, 0));
		assertNull(user);
		
//		selectAll();
//		selectOne();
//		create();
//		update();
//		delete();
//		createReply();
//		readReplyByBno();
//		updateReply();
//		deleteReply();
//		updateReplyCnt();
	} // end doTest()
	
	private void updateReplyCnt() {
		int result = boardDao.update(6, -1);
		log.info("댓글 갯수 수정 결과 = {}", result);
	}
	
	private void deleteReply() {
		Integer bno = replyDao.readBno(4);  // 4번 댓글의 글 번호
		log.info("bno = {}", bno);
		
		int result = replyDao.delete(4); // 4번 댓글 삭제
		log.info("댓글 삭제 결과 = {}", result);
	}
	
	private void updateReply() {
		Reply reply = new Reply(100, "댓글 수정 TEST", null, 0, null);
		int result = replyDao.update(reply);
		log.info("댓글 수정 결과 = {}", result);
	}
	
	private void readReplyByBno() {
		List<Reply> list = replyDao.read(100);
		log.info("댓글 갯수 = {}", list.size());
		for (Reply reply : list) {
			log.info(reply.toString());
		}
	}
	
	private void createReply() {
		log.info("replyDao: {}", replyDao);
		
		Reply reply = new Reply(0, "댓글 4", "admin", 10, null);
		int result = replyDao.create(reply);
		log.info("댓글 insert 결과 = {}", result);
	}
	
	private void selectAll() {
		log.info("boardDao: {}", boardDao);
		List<Board> list = boardDao.read();
		for (Board b : list) {
			log.info(b.toString());
		}
	}
	
	private void selectOne() {
		Board b = boardDao.read(2);
		log.info(b.toString());
	}
	
	private void create() {
		Board board = new Board(0, 
				"Spring-MyBatis 테스트",	// title
				"새 글 작성 Test",			// content
				"guest",				// userid
				null, 0, null);
		int result = boardDao.create(board);
		log.info("insert 결과 = " + result);
	}
	
	private void update() {
		Board board = boardDao.read(7);
//		board.setBno(100);
		board.setTitle("수정 test");
		board.setContent("Spring-MyBatis를 사용한 DB update 테스트");
		int result = boardDao.update(board);
		log.info("update 결과 = {}", result);
	}
	
	private void delete() {
		int result = boardDao.delete(7);
		log.info("delete 결과 = {}", result);
	}
} // end class DaoTest





