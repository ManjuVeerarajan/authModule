package com.saama.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.core.annotation.Order;

import lombok.Data;

@Entity
@Table(name = "USERPRIVILEGE", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "privilege_id" }) })
@Data
public class UserPrivilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id")
	private Privilege privilegeId;
}
