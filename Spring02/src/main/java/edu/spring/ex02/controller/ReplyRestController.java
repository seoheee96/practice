package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.service.ReplyService;

@RestController
@RequestMapping(value = "/replies")
public class ReplyRestController {
	private static final Logger log =
			LoggerFactory.getLogger(ReplyRestController.class);
	
	@Autowired private ReplyService replyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(
			@RequestBody Reply reply) {
		// @RequestBody: 클라이언트(브라우저)에서 보내는 데이터가 요청 패킷 본문(body)에 
		// 포함되어 있음을 알려주는 어노테이션
		// 요청 시 보내는 데이터가 질의 문자열에 있지 않고, form-data도 아닌 경우에 사용
		log.info("createReply({})", reply);
		
		int result = replyService.create(reply);
		
		ResponseEntity<Integer> entity = 
				new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return entity;
	} // end createReply()
	
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> readAllReplies(
			@PathVariable(name = "bno") Integer bno) {
		log.info("readAllReplies(bno={})", bno);
		
		List<Reply> list = replyService.read(bno);
		
		ResponseEntity<List<Reply>> entity = 
				new ResponseEntity<List<Reply>>(list, HttpStatus.OK);
		
		return entity;
	} // end readAllReplies()
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable(name = "rno") Integer rno,
			@RequestBody Reply reply) {
		log.info("updateReply(rno={}, {})", rno, reply);
		reply.setRno(rno);
		int result = replyService.update(reply);
		String res = "";
		if (result == 1) {
			res = "s"; // 성공(success)
		} else {
			res = "f"; // 실패(fail)
		}
		
		ResponseEntity<String> entity = 
				new ResponseEntity<String>(res, HttpStatus.OK);
		
		return entity;
	} // end updateReply()

	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteReply(
			@PathVariable(name = "rno") Integer rno) {
		log.info("deleteReply(rno={})", rno);
		
		int result = replyService.delete(rno);
		
		ResponseEntity<Integer> entity = 
				new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return entity;
	} // end deleteReply()
	
} // end class ReplyRestController





