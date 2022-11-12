package com.greatlearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Roles;
import com.greatlearning.employee.repository.RolesRepository;

@Service
public class RoleService {
	@Autowired
	private RolesRepository roleRepository;

	public Roles addRole(Roles role) {
		return roleRepository.saveAndFlush(role);
	}

}
