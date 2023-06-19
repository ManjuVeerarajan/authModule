package com.saama.service;

import org.springframework.stereotype.Service;

import com.saama.model.PrivilegeData;

@Service
public interface AuthService {

	public PrivilegeData getPrivileges(Long id);

}
