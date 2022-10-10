package com.sdc.userservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sdc.userservice.dto.UserDto;
import com.sdc.userservice.repository.entity.UserEntity;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto);

	UserDto getUserByUserId(String userId);

	Iterable<UserEntity> getUserByAll();

}
