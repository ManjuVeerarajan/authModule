package com.testo.urlshortener.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testo.urlshortener.entity.StatisticsEntity;
import com.testo.urlshortener.repo.StatisticsRepo;

@Service
public class StatsServiceImpl implements StatsService{
	
	@Autowired
	StatisticsRepo repo;
	
	public List<StatisticsEntity> getAll() {
		List<StatisticsEntity> findAll = (List<StatisticsEntity>) repo.findAll();
		return findAll;
	}

}
