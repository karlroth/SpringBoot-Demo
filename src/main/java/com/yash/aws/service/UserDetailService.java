package com.yash.aws.service;

import com.yash.aws.model.User;
import com.yash.aws.model.UserDetail;

public interface UserDetailService {

	UserDetail setUserDetail(UserDetail userDetail);
	
	UserDetail findUserInfo(User user);
	
}
