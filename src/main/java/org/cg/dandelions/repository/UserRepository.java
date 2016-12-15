package org.cg.dandelions.repository;

import org.cg.dandelions.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUserName(String username);
	
}
