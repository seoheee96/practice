package edu.spring.ex02.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.User;
import edu.spring.ex02.persistence.UserDao;

@Service
public class UserServiceImple implements UserService {

	private static final Logger log =
			LoggerFactory.getLogger(UserServiceImple.class);
	
	@Autowired private UserDao userDao;
	
	@Override
	public User signinCheck(User user) {
		log.info("signinCheck({})", user);
		
		return userDao.signinCheck(user);
	}

} // end class UserServiceImple

