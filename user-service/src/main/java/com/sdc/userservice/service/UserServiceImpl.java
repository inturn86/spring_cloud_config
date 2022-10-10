package com.sdc.userservice.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sdc.userservice.dto.UserDto;
import com.sdc.userservice.repository.UserRepository;
import com.sdc.userservice.repository.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder encoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setUserId(UUID.randomUUID().toString());

		ModelMapper mapper = new ModelMapper();

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		userEntity.setEncryptedPwd(encoder.encode(userDto.getPwd()));

		userRepository.save(userEntity);

		UserDto returnUserDto = mapper.map(userEntity, UserDto.class);

		return returnUserDto;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		// TODO Auto-generated method stub

		UserEntity user = userRepository.findByUserId(userId);

		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}

		UserDto userDto = new ModelMapper().map(user, UserDto.class);

		userDto.setOrders(new ArrayList<>());

		return userDto;
	}

	@Override
	public Iterable<UserEntity> getUserByAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(username);

		if(userEntity == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(), true, true, true, true, new ArrayList<>());
	}

}
