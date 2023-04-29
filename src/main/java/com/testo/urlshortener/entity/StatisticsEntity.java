package com.testo.urlshortener.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "StatisticsEntity")
@Data
public class StatisticsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "urlShortenedAt")
	private LocalDateTime urlShortenedAt;
	@Column(name = "shortUrlAccessedAt")
	private LocalDateTime shortUrlAccessedAt;
	@Column(name = "urlShoretened")
	private Boolean urlShoretened = Boolean.FALSE;
	@Column(name = "shortUrlAccessed")
	private Boolean shortUrlAccessed = Boolean.FALSE;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "entityId", referencedColumnName = "id")
	private UrlEntity entityId;

}
