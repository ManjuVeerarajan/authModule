package com.saama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.annotation.Order;

import lombok.Data;

@Entity
@Table(name = "Roles")
@Data
@Order(1)
public class Roles {
	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
}