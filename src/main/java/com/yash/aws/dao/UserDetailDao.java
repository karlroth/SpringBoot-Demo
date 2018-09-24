package com.yash.aws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.aws.model.UserDetail;

@Repository
public interface UserDetailDao extends CrudRepository<UserDetail, Long>{

}
