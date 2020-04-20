package com.kinner.ksbe.service;

import com.kinner.ksbe.domain.City;

import java.util.List;

public interface CityService {

    Long saveCity(City city);

    List<City> searchCity(Integer pageNo, Integer pageSize, String searchContents);

}
