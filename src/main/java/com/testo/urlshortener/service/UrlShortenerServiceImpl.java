package com.testo.urlshortener.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.testo.urlshortener.entity.StatisticsEntity;
import com.testo.urlshortener.entity.UrlEntity;
import com.testo.urlshortener.model.Statistics;
import com.testo.urlshortener.model.UrlDto;
import com.testo.urlshortener.model.UrlStatistics;
import com.testo.urlshortener.repo.StatisticsRepo;
import com.testo.urlshortener.repo.UrlShorternerRepo;
import com.testo.urlshortener.utilities.GlobalConstants;

/**
 * @author Manju Veerarajan
 *
 */
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

	Logger logger = LoggerFactory.getLogger(UrlShortenerServiceImpl.class);

	@Autowired
	UrlShorternerRepo urlShortenerRepo;

	@Autowired
	StatisticsRepo statisticsRepo;

	@Value("${server.contextPath}")
	private String domain;

	/**
	 * @param url
	 * @return shortenUrl long url is shortened and data are persisted and updated
	 *         in different table to maintain statistics
	 */
	@Override
	public ResponseEntity<?> shortenUrl(UrlDto url, HttpServletRequest request) {
		try {
			logger.info(url.toString());
			String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
			UrlValidator urlValidator = new UrlValidator(new String[] { GlobalConstants.HTTP, GlobalConstants.HTTPS });
			if (url != null && url.getUrl() != null && urlValidator.isValid(url.getUrl().toString())) {
				UrlEntity data;
				data = findAndUpdateByUrl(url.getUrl());
				StatisticsEntity stats = new StatisticsEntity();
				if (data == null) {
					data = saveUrl(url);
					stats.setEntityId(data);
					stats.setUrlShortenedAt(LocalDateTime.now());
					stats.setUrlShoretened(Boolean.TRUE);
					statisticsRepo.save(stats);
				} else {
					stats.setEntityId(data);
					stats.setUrlShortenedAt(LocalDateTime.now());
					stats.setUrlShoretened(Boolean.TRUE);
					statisticsRepo.save(stats);
				}
				String shortUrl = host + domain + data.getId();
				URL shortenedUrl = new URL(shortUrl);
				Statistics statisticData = new Statistics(data.getShortUrlAccessCount(), data.getUrlShoretenedCount(),
						stats.getUrlShortenedAt(), data.getUpdatedAt());
				UrlStatistics statistics = new UrlStatistics(shortenedUrl, statisticData);
				return new ResponseEntity<>(statistics, HttpStatus.CREATED);
			} else {

				return new ResponseEntity<>(GlobalConstants.URL_INVALID, HttpStatus.CREATED);
			}
		} catch (MalformedURLException e) {
			logger.error(e.getLocalizedMessage());
			return new ResponseEntity<>(GlobalConstants.URL_INVALID, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param id
	 * @param response
	 * @return redirets the url to the acutal long url
	 */
	@Override
	public void redirectUrl(int id, HttpServletResponse response) {
		try {
			UrlEntity data = findById(id);
			StatisticsEntity stats = new StatisticsEntity();
			if (data != null) {
				// saving data for satistics
				stats.setEntityId(data);
				stats.setShortUrlAccessedAt(LocalDateTime.now());
				stats.setShortUrlAccessed(Boolean.TRUE);
				statisticsRepo.save(stats);

				data.setShortUrlAccessCount(data.getShortUrlAccessCount() + 1);
				data.setUpdatedAt(LocalDateTime.now());
				updateUrlStats(data);
				response.sendRedirect(data.getUrl().toString());
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}

		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	/**
	 * @param data(UrlDto)
	 * @return persists the urlEntity by updating the url shortened count and
	 *         createdAt
	 */
	@Override
	public UrlEntity saveUrl(UrlDto data) {
		try {
			UrlEntity entity = new UrlEntity();
			entity.setUrl(data.getUrl());
			entity.setCreatedAt(LocalDateTime.now());
			entity.setUrlShoretenedCount(1L);
			UrlEntity persistedEnity = urlShortenerRepo.save(entity);
			return persistedEnity;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param id
	 * @return finds the urlEntity data by Id
	 */
	@Override
	public UrlEntity findById(int id) {
		try {
			Optional<UrlEntity> urlData = urlShortenerRepo.findById(id);
			if (!urlData.isEmpty()) {
				return urlData.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param url
	 * @return to update the url shortened count and updatedAt by url
	 */
	@Override
	public UrlEntity findAndUpdateByUrl(URL url) {
		try {
			UrlEntity urlData = urlShortenerRepo.findByUrl(url);
			if (urlData != null) {
				urlData.setUrlShoretenedCount(urlData.getUrlShoretenedCount() + 1);
				urlData.setUpdatedAt(LocalDateTime.now());
				urlShortenerRepo.save(urlData);
			}
			return urlData;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param urlEntity
	 * @return updates the urlEntity for the given Id
	 */
	@Override
	public UrlEntity updateUrlStats(UrlEntity entity) {
		try {
			urlShortenerRepo.save(entity);
			return null;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 *
	 */
	@Override
	public List<UrlEntity> getAll() {
		try {
			List<UrlEntity> findAll = (List<UrlEntity>) urlShortenerRepo.findAll();
			return findAll;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}

}
