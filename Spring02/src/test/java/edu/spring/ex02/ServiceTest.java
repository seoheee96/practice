package edu.spring.ex02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
		)
@WebAppConfiguration
public class ServiceTest {
	private static final Logger log =
			LoggerFactory.getLogger(ServiceTest.class);
	
	@Autowired ReplyService replyService;
	
	@Test
	public void doTest() {
//		createReply();
		deleteReply();
	}

	private void deleteReply() {
		int result = replyService.delete(5);
		log.info("댓글 삭제 결과 = {}", result);
	}
	
	private void createReply() {
		Reply reply = new Reply(0, 		// 댓글 번호 -> 필요 없음(자동 생성)
				"댓글 입력 service test",	// 댓글 내용
				"guest", 				// 댓글 작성자 아이디
				10, 					// 댓글이 달릴 게시글의 글 번호(bno)
				null);					// 댓글 작성 시간 -> 필요 없음(자동 입력)
		int result = replyService.create(reply);
		log.info("댓글 입력 결과: " + result);
	}
	
}









