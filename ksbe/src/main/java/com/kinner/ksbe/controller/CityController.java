package com.kinner.ksbe.controller;

import com.kinner.ksbe.domain.City;
import com.kinner.ksbe.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/add", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city)
    {
        return cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/search", method = RequestMethod.GET)
    public List<City> searchCity(@RequestParam(value = "pageNo") Integer pageNo,
                                 @RequestParam(value = "pageSize") Integer pageSize,
                                 @RequestParam(value = "searchContents") String searchContents)
    {
        return cityService.searchCity(pageNo, pageSize, searchContents);
    }

}
