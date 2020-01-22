package edu.spring.ex02.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex02.domain.User;
import edu.spring.ex02.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger log =
			LoggerFactory.getLogger(UserController.class);
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void signin(String target, Model model) {
		log.info("sigin(target={}) GET 호출", target);
		
		if (target != null && !target.equals("")) {
			model.addAttribute("target", target);
			// 로그인 성공 후에 이동할 페이지를 저장해둠
		}
	} // end signin()

	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public void signin(User user, Model model) {
		log.info("signin({})", user);
		
		// UserService의 메소드를 사용해서 로그인 처리(성공/실패)
		User signinUser = userService.signinCheck(user);
		log.info("signinUser: {}", signinUser);
		
		// model 객체에 로그인 정보(signinId)를 attribute로 추가
		model.addAttribute("signinUser", signinUser);
		
	} // end signin(user)
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		log.info("signOut() 호출");
		session.removeAttribute("signinId");
		session.invalidate(); // 세션 객체 무효화(세션 객체 소멸, 새로 생성)
		
		return "redirect:/user/signin";
	}
	
} // end class UserController













