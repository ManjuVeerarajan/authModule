package com.testo.urlshortener.service;

import java.util.List;

import com.testo.urlshortener.entity.StatisticsEntity;

public interface StatsService {

	public List<StatisticsEntity> getAll();
	
}
