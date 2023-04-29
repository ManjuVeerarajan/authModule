package com.testo.urlshortener.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testo.urlshortener.entity.StatisticsEntity;
import com.testo.urlshortener.model.UrlDto;

/**
 * @author Manju Veerarajan
 *
 */
@RestController
@RequestMapping("/testo")
public interface UrlShortenerApi {

	@PostMapping(path = "/shortenUrl", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<?> shortenUrl(@RequestBody UrlDto data,  HttpServletRequest request);

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void redirectUrl(@PathVariable int id, HttpServletResponse response) throws Exception;

	@GetMapping(value = "/")
	public List<StatisticsEntity> statistics();

}
