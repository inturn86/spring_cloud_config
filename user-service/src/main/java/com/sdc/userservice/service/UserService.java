package com.sdc.userservice.service;

import com.sdc.userservice.dto.UserDto;
import com.sdc.userservice.repository.entity.UserEntity;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getUserByUserId(String userId);

	Iterable<UserEntity> getUserByAll();

}
