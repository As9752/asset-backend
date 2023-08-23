package com.kloudspot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.UserAlreadyExistsException;
import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.mapper.UserMapper;
import com.kloudspot.model.User;
import com.kloudspot.model.record.UserRecord;
import com.kloudspot.repository.UserRepository;
import com.kloudspot.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserRecord> getAllUsers() {
		return userRepository.findAll().stream().map(userRecord -> userMapper.convertToUserRecord(userRecord)).toList();
	}

	@Override
	public UserRecord getUserById(String userId) throws UserNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with given id Not found"));
		return userMapper.convertToUserRecord(user);
	}

	@Override
	public UserRecord createUser(UserRecord userRecord) throws UserAlreadyExistsException {
		boolean userExists = userRepository.existsByUserId(userRecord.userId());

		if (!userExists) {
			return userMapper.convertToUserRecord(userRepository.save(userMapper.convertToUser(userRecord)));
		}

		throw new UserAlreadyExistsException("User with ID " + userRecord.userId() + " already exists.");
	}

	@Override
	public List<UserRecord> createUsers(List<UserRecord> usersRecords) {
		List<UserRecord> usersGotAdded = new ArrayList<>();
		usersRecords.forEach(user -> {
			if (!userRepository.existsById(user.userId())) {
				try {
					createUser(user);
				} catch (UserAlreadyExistsException e) {
				}
				usersGotAdded.add(user);
			}
		});
		return usersGotAdded;
	}

	@Override
	public UserRecord updateUser(String userId, UserRecord userRecord) throws UserNotFoundException {
		boolean userExists = userRepository.existsByUserId(userId);

		if (userExists) {
			return userMapper.convertToUserRecord(userRepository.save(userMapper.convertToUser(userRecord)));
		}

		throw new UserNotFoundException("User with ID " + userRecord.userId() + " already exists.");
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}
}