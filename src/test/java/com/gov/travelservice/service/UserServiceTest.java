package com.gov.travelservice.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest({ "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect", "logging.level.org.hibernate.SQL=DEBUG",
		"logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	public void testFindByUserId() {
		System.out.println(userService.findByUserId(3).getFirst_name());
		System.out.println(userService.findByUserId(3));
		System.out.println(userService.findByUserId(3).getUserRoles().get(0).getId().getRole().getRoleName());
	}
}
