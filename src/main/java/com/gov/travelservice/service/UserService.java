package com.gov.travelservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gov.travelservice.entity.User;
import com.gov.travelservice.repository.UserRepository;

@Service
@Transactional(readOnly=true)
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findByUserId(long userId) {
		return userRepository.findById(userId);
	}

	public User authenticateuser(String username) {
		return userRepository.findByUsername(username);
	}
}
