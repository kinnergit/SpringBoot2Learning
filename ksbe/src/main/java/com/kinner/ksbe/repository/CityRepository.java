package com.kinner.ksbe.repository;

import com.kinner.ksbe.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends ElasticsearchRepository<City, Long> {
}
