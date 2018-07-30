package com.zoya.belt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zoya.belt.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

}
