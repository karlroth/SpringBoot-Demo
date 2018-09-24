package com.yash.aws.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.aws.model.User;

public class UserRowMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setEmail(resultSet.getString("email"));
		user.setUserName(resultSet.getString("user_name"));
		user.setPassword(resultSet.getString("password"));
		
		return user;
	}
}
