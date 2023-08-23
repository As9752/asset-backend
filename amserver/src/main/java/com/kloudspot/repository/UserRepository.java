package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	boolean existsByUserId(String userId);

}