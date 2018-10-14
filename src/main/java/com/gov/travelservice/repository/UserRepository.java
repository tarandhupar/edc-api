package com.gov.travelservice.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gov.travelservice.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findById(long id);

	public User findByUsername(String username);
}
