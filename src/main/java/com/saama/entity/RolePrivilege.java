package com.saama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "ROLEPRIVILEGE", uniqueConstraints = { @UniqueConstraint(columnNames = { "role_id", "privilege_id" }) })
@Data
public class RolePrivilege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Roles roles;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "privilege_id", nullable = false)
	private Privilege privileges;
}
