package com.testo.urlshortener.entity;

import java.net.URL;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "urlEntity")
@Data
public class UrlEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Id")
	private int id;
	@Lob
	@Column(name = "url")
	private URL url;
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	@Column(name = "urlShoretenedCount")
	private Long urlShoretenedCount;
	@Column(name = "shortUrlAccessCount")
	private Long shortUrlAccessCount = 0L;
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

}
