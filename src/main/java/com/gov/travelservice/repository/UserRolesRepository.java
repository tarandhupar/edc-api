package com.gov.travelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gov.travelservice.entity.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long>, JpaSpecificationExecutor<UserRoles> {

}
