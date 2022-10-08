package com.sdc.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.sdc.userservice.repository.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	UserEntity findByUserId(String userId);
}
