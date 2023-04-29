package com.testo.urlshortener.model;

import java.net.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlStatistics {

	private URL shortUrl;
	private Statistics statistics;
	
}
