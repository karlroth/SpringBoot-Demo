package com.yash.aws.serviceimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.aws.dao.UserDao;
import com.yash.aws.exception.UserAuthenticationException;
import com.yash.aws.model.User;
import com.yash.aws.rowmapper.UserRowMapper;
import com.yash.aws.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	private JdbcTemplate jdbcTemplate;
	private UserRowMapper userRowMapper = new UserRowMapper();
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public User registerUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User authenticate(String userName, String password) throws UserAuthenticationException {
		String sql = "SELECT * FROM users WHERE user_name=? AND password=?";
		User user = jdbcTemplate.queryForObject(sql,userRowMapper, userName, password);
		if(user == null) {
			throw new UserAuthenticationException();
		}
		return user; 
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		return jdbcTemplate.queryForObject(sql, userRowMapper, id);
	}

}
