package com.saama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Roles")
@Data
public class Roles {
	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
}