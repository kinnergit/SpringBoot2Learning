package com.kinner.ksbe.service;

import com.kinner.ksbe.domain.City;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {

    Long saveCity(City city);

    List<City> searchCity(Integer pageNo, Integer pageSize, String searchContents);

}
