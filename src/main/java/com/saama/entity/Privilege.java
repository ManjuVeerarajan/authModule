package com.saama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.annotation.Order;

import lombok.Data;

@Entity
@Table(name = "Privilege")
@Data
@Order(2)
public class Privilege {
	@Id
	@Column(name = "privilege_id")
	private Long privilegeId;
	@Column(name = "privilege_name")
	private String privilegeName;
}