package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.UserAlreadyExistsException;
import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.model.record.UserRecord;

public interface IUserService {
	List<UserRecord> getAllUsers();

	UserRecord getUserById(String userId) throws UserNotFoundException;

	UserRecord createUser(UserRecord user) throws UserAlreadyExistsException;

	UserRecord updateUser(String userId, UserRecord user) throws UserNotFoundException;

	List<UserRecord> createUsers(List<UserRecord> users);

	void deleteUser(String userId);
}
