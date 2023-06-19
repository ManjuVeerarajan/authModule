package com.saama.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "USERPRIVILEGE", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "privilege_id" }) })
@Data
public class UserPrivilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User users;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "privilege_id", nullable = false)
	private Privilege privileges;
}
