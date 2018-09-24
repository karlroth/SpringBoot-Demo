package com.yash.aws.serviceimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.aws.dao.UserDetailDao;
import com.yash.aws.model.User;
import com.yash.aws.model.UserDetail;
import com.yash.aws.rowmapper.UserDetailRowMapper;
import com.yash.aws.service.UserDetailService;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserDetailDao userDetailDao;
	private JdbcTemplate jdbcTemplate;
	private UserDetailRowMapper userDetailRowMapper = new UserDetailRowMapper();
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public UserDetail setUserDetail(UserDetail userDetail) {
		return userDetailDao.save(userDetail);
	}

	@Override
	public UserDetail findUserInfo(User user) {
		int userId = user.getId();
		String sql = "SELECT * FROM user_detail WHERE user_id=?";
		return jdbcTemplate.queryForObject(sql, userDetailRowMapper, userId);
	}

}
