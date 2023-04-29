package com.testo.urlshortener.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.testo.urlshortener.api.UrlShortenerApi;
import com.testo.urlshortener.entity.StatisticsEntity;
import com.testo.urlshortener.model.UrlDto;
import com.testo.urlshortener.service.StatsServiceImpl;
import com.testo.urlshortener.service.UrlShortenerService;

/**
 * @author Manju Veerarajan
 *
 */
@RestController
public class UrlShortenerApiController implements UrlShortenerApi {

	@Autowired
	UrlShortenerService urlShortenerService;

	@Autowired
	StatsServiceImpl statsServiceImpl;

	Logger logger = LoggerFactory.getLogger(UrlShortenerApiController.class);

	/**
	 * @param url
	 * @param resp
	 * @return
	 * validates and shortens the given long url and returns the shorterened url 
	 */
	@Override
	public ResponseEntity<?> shortenUrl(UrlDto url, HttpServletRequest request) {
		ResponseEntity<?> shortenUrl = urlShortenerService.shortenUrl(url, request);
		logger.info(shortenUrl.toString());
		return shortenUrl;
	}

	/**
	 * @param id
	 * @param resp
	 * @return
	 * redirects the shorten url and displays the document of the unabridged URL
	 */
	@Override
	public void redirectUrl(int id, HttpServletResponse response) throws Exception {
		urlShortenerService.redirectUrl(id, response);
	}

	/**
	 *
	 */
	@Override
	public List<StatisticsEntity> statistics() {
		try {
			List<StatisticsEntity> all = statsServiceImpl.getAll();
			return all;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
