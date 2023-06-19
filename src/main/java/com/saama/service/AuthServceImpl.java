package com.saama.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saama.api.controller.AuthApiController;
import com.saama.entity.RolePrivilege;
import com.saama.entity.UserPrivilege;
import com.saama.model.UserRoles;
import com.saama.repo.RolePrivilegeRepository;
import com.saama.repo.UserPrivilegeRepository;

@Service
public class AuthServceImpl implements AuthService {

	@Autowired
	UserPrivilegeRepository userPrivilegeRepo;

	@Autowired
	RolePrivilegeRepository roleRepo;

	Logger logger = LoggerFactory.getLogger(AuthServceImpl.class);

	/**
	 * @param id
	 * @return PrivilegeData ---> which contains the role details and privileges
	 *         details of the given user
	 */
	@Override
	public UserRoles getUserRoles(Long id) {
		try {
			UserRoles data = new UserRoles();
			List<UserPrivilege> userPrivileges = userPrivilegeRepo.findAllByUsersUserId(id);
			List<Long> ids = userPrivileges.stream().map(e -> e.getPrivileges().getPrivilegeId())
					.collect(Collectors.toList());
			List<RolePrivilege> roleDetails = roleRepo.findAllByPrivilegesPrivilegeIdIn(ids);
			List<String> roleNames = roleDetails.stream().map(e -> e.getRoles().getRoleName())
					.collect(Collectors.toList());
			data.setRoles(roleNames);
			return data;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

}
