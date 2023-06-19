package com.saama.service;

import org.springframework.stereotype.Service;

import com.saama.model.UserRoles;

@Service
public interface AuthService {

	public UserRoles getUserRoles(Long id);

}
