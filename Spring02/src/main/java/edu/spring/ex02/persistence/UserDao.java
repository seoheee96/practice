package edu.spring.ex02.persistence;

import edu.spring.ex02.domain.User;

public interface UserDao {
	
	int update(String userid, int points);
	User signinCheck(User user); 

}
