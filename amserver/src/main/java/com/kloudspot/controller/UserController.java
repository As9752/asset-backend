package com.kloudspot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloudspot.DTO.UserListWrapper;
import com.kloudspot.exception.UserAlreadyExistsException;
import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.model.record.UserRecord;
import com.kloudspot.service.IUserService;

/* 
 * User Endpoints:


Get All Users
Endpoint: /api/v1/users
Method: GET
Description: Fetches a list of all users.

Get User by ID
Endpoint: /api/v1/users/{userId}
Method: GET
Description: Retrieves a specific user based on the provided user ID.

Create New User
Endpoint: /api/v1/users
Method: POST
Description: Adds a new user to the system.

Update User
Endpoint: /api/v1/users/{userId}
Method: PUT
Description: Updates details of an existing user using the provided user ID.

Delete User
Endpoint: /api/v1/users/{userId}
Method: DELETE
Description: Removes a user based on the provided user ID.
 */

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity<List<UserRecord>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserRecord> getUserById(@PathVariable String userId) throws UserNotFoundException {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserRecord> createUser(@RequestBody UserRecord user) throws UserAlreadyExistsException {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/bulk")
	public ResponseEntity<List<UserRecord>> createUsers(@RequestBody UserListWrapper userListWrapper) {
		List<UserRecord> savedUsers = userService.createUsers(userListWrapper.getData());
		return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserRecord> updateUser(@PathVariable String userId, @RequestBody UserRecord user)
			throws UserNotFoundException {
		return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
