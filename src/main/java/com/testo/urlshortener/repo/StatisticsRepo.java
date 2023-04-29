package com.testo.urlshortener.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testo.urlshortener.entity.StatisticsEntity;

@Repository
public interface StatisticsRepo extends CrudRepository<StatisticsEntity, Integer> {

}
