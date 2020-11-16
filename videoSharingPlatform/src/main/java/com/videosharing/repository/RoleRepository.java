package com.videosharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.videosharing.model.Role;

public interface RoleRepository extends CrudRepository<Role, String>{
	
}
