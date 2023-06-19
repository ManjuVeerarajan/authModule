package com.saama.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saama.api.controller.AuthApiController;
import com.saama.entity.RolePrivilege;
import com.saama.entity.UserPrivilege;
import com.saama.model.PrivilegeData;
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
	public PrivilegeData getPrivileges(Long id) {
		try {
			PrivilegeData data = new PrivilegeData();
			List<UserPrivilege> userPrivileges = userPrivilegeRepo.findAllByUserIdUserId(id);
			List<Long> ids = new ArrayList<>();
			List<String> privilegeName = new ArrayList<>();
			List<String> roleNames = new ArrayList<>();
			for (UserPrivilege userPrivilege : userPrivileges) {
				ids.add(userPrivilege.getPrivilegeId().getPrivilegeId());
				privilegeName.add(userPrivilege.getPrivilegeId().getPrivilegeName());
			}
			List<RolePrivilege> roleDetails = roleRepo.findAllByPrivilegeIdPrivilegeIdIn(ids);
			for (RolePrivilege rolePrivilege : roleDetails) {
				roleNames.add(rolePrivilege.getRoleId().getRoleName());
			}
			data.setPrivileges(privilegeName);
			data.setRoles(roleNames);
			return data;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

}
