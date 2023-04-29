package com.testo.urlshortener.service;

import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.testo.urlshortener.entity.UrlEntity;
import com.testo.urlshortener.model.UrlDto;

public interface UrlShortenerService {
	
	public ResponseEntity<?> shortenUrl(UrlDto url, HttpServletRequest request);
	
	public void redirectUrl(int id, HttpServletResponse response);

	public UrlEntity saveUrl(UrlDto data);
	
	public UrlEntity findById(int id);
	
	public UrlEntity findAndUpdateByUrl(URL url);
	
	public UrlEntity updateUrlStats(UrlEntity entity);
	
	public List<UrlEntity> getAll();

}
