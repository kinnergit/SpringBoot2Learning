package com.kinner.ksbe.service.impl;

import com.kinner.ksbe.domain.City;
import com.kinner.ksbe.repository.CityRepository;
import com.kinner.ksbe.service.CityService;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityESServiceImpl implements CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    @Autowired
    CityRepository cityRepository;

    @Override
    public Long saveCity(City city) {
        City cityRet = cityRepository.save(city);

        return cityRet.getId();
    }

    @Override
    public List<City> searchCity(Integer pageNo, Integer pageSize, String searchContents) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("cityName", searchContents)).boost(5)
                .should(QueryBuilders.matchQuery("description", searchContents)).boost(3);

        FunctionScoreQueryBuilder query = QueryBuilders.functionScoreQuery(queryBuilder)
                .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                .boostMode(CombineFunction.SUM);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(query).build();

        Page<City> searchPageResults = cityRepository.search(searchQuery);

        String log = "search='" + searchContents + "', query=" + replaceWhitespaces(searchQuery.getQuery().toString());
        LOGGER.info(log);

        return searchPageResults.getContent();
    }

    private static String replaceWhitespaces(String s)
    {
        return s.replaceAll("[\f\t\r\n\\s]*", "");
    }

}
