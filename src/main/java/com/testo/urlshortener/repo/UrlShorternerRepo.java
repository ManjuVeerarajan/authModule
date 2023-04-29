package com.testo.urlshortener.repo;

import java.net.URL;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testo.urlshortener.entity.UrlEntity;

@Repository
public interface UrlShorternerRepo extends CrudRepository<UrlEntity, Integer> {
	
	UrlEntity findByUrl(URL url);
	
}
