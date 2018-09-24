package com.yash.aws.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yash.aws.model.User;
import com.yash.aws.model.UserDetail;
import com.yash.aws.service.UserService;

//@Component
public class UserDetailRowMapper implements RowMapper<UserDetail>{

//	@Autowired
//	UserService userService;
//	
	@Override
	public UserDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDetail userDetail = new UserDetail();
		userDetail.setId(resultSet.getInt("id"));
		
//		User user = userService.getUserById(resultSet.getInt("user_id"));
		userDetail.setUser(new User());
		
		
		userDetail.setFirstName(resultSet.getString("first_name"));
		userDetail.setLastName(resultSet.getString("last_name"));
		userDetail.setPhoneNumber(resultSet.getString("phone_number"));
		userDetail.setAddress(resultSet.getString("address"));
		
		return userDetail;
	}
}
