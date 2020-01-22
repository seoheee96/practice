package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.service.ReplyService;

@RestController
public class SampleController2 {
	private static final Logger log =
			LoggerFactory.getLogger(SampleController2.class);

	@Autowired private ReplyService replyService;
	
	@RequestMapping(value = "/sample1", method = RequestMethod.GET)
	public Reply sample1() {
		log.info("sample1() 호출");
		
		return new Reply(1000, "REST API 테스트", "admin", 1, null);
	} // end sample1()
	
	@RequestMapping(value = "/sample2", method = RequestMethod.GET)
	public List<Reply> sample2() {
		log.info("sample2() 호출");
		
		return replyService.read(1);
	} // end sample2()
	
	@RequestMapping(value = "/sample3", method = RequestMethod.GET)
	public ResponseEntity<Reply> sample3() {
		log.info("sample3() 호출");
		Reply reply = new Reply(1000, "REST API 테스트", "admin", 1, null);
		ResponseEntity<Reply> entity =
				new ResponseEntity<Reply>(reply, HttpStatus.BAD_REQUEST);
		
		return entity;
	} //end sample3()
	
	@RequestMapping(value = "/sample4", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> sample4() {
		log.info("sample4() 호출");
		List<Reply> list = replyService.read(10);
		ResponseEntity<List<Reply>> entity =
				new ResponseEntity<List<Reply>>(list, HttpStatus.PARTIAL_CONTENT);
		
		return entity;
	}
	
} // end class SampleController2






