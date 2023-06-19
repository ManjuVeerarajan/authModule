package com.saama.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.saama.entity.RolePrivilege;
import com.saama.entity.UserPrivilege;

public interface RolePrivilegeRepository extends CrudRepository<RolePrivilege, Long> {

	List<RolePrivilege> findAllByPrivilegeIdPrivilegeIdIn(List<Long> ids);
}
