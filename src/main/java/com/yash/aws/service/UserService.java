package com.yash.aws.service;

import com.yash.aws.exception.UserAuthenticationException;
import com.yash.aws.model.User;

public interface UserService {

	User registerUser(User user);

	User authenticate(String userName, String password) throws UserAuthenticationException;

	User getUserById(int id);
}