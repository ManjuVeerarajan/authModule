package com.saama.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saama.entity.UserPrivilege;

@Repository
public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege, Long> {
	
	List<UserPrivilege> findAllByUsersUserId(Long user_id);
	
}
