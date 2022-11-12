package com.greatlearning.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employee.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users getUserByUsername(String username);

}
