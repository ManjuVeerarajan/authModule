package com.testo.urlshortener.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
	private Long shortUrlAccessCount;
	private Long urlShoretenedCount;
	private LocalDateTime urlShortenedAt;
	private LocalDateTime shortUrlAccessedAt;
}
