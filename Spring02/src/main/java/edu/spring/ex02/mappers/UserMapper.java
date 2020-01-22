package edu.spring.ex02.mappers;

import org.apache.ibatis.annotations.Select;

import edu.spring.ex02.domain.User;

public interface UserMapper {
	String SQL_SIGNIN_CHECK = 
			"select * from ${tbl_users}"
			+ " where userid = #{userid} and pwd = #{pwd}";
	
	@Select(SQL_SIGNIN_CHECK)
	User signinCheck(User user);
}
