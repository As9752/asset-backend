package com.kloudspot.mapper;

import org.springframework.stereotype.Component;

import com.kloudspot.model.User;
import com.kloudspot.model.record.UserRecord;

@Component
public class UserMapper {

	public User convertToUser(UserRecord userRecord) {
		User user = new User(userRecord.userId(), userRecord.name(), userRecord.userEmail(), userRecord.roles());
		return user;
	}

	public UserRecord convertToUserRecord(User user) {
		UserRecord userRecord = new UserRecord(user.getUserId(), user.getName(), user.getRoles(), user.getUserEmail());
		return userRecord;
	}

}
