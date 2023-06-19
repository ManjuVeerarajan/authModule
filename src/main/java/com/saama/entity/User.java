package com.saama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.annotation.Order;

import lombok.Data;

@Entity
@Table(name = "User")
@Data
@Order(3)
public class User {

	@Id
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;

}
