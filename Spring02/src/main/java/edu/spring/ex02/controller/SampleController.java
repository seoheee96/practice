package edu.spring.ex02.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex02.domain.Reply;

@Controller
public class SampleController {
	private static final Logger log =
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test1() {
		log.info("test1() 호출");
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		log.info("test2() 호출");
		
		return "test";
	}

	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	@ResponseBody
	public String test3() {
		log.info("test3() 호출");
		
		return "test";
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	@ResponseBody
	public Reply test4() {
		log.info("test4() 호출");
		
		// 콘트롤러 메소드에 @ResponseBody 어노테이션이 설정되어 있고,
		// pom.xml 파일에 jackson-databind 의존성(dependency)가 추가되어 있으면,
		// DispatcherServlet은 콘트롤러 메소드가 리턴하는 Java 객체를
		// JSON 형식의 문자열로 변환해서 응답(response)를 보냄
		return new Reply(123, "댓글", "guest", 100, new Date());
	}
	
} // end class SampleController








