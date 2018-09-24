package com.yash.aws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.aws.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

}
