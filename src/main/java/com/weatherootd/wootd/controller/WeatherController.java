package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.entity.Region;
import com.weatherootd.wootd.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wootds")
public class WeatherController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private RestWeatherController restWeatherController;

    @PostMapping("/parseAddress")
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getParseAddress (@RequestParam("addrSido") String addrSido,
                                                                @RequestParam("addrSugungu") String addrSigungu,
                                                                @RequestParam("addrEmdong") String addrEmdong,
                                                                 @RequestParam("weatherDate") String weatherDate,
                                                                 @RequestParam("weatherTime") String weatherTime
                                                                 ) {

        List<Region> regions = regionRepository.findByNxNy(addrSido, addrSigungu, addrEmdong);
        if (regions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Region region = regions.get(0);
        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("nx", region.getNx());
        coordinates.put("ny", region.getNy());

        String base_date = weatherDate;
        String base_time = weatherTime;
        String dataType = "JSON";
        String weatherInfo = restWeatherController.getWeather(base_date, base_time, dataType, String.valueOf(region.getNx()), String.valueOf(region.getNy()));

        System.out.println("-------------------------");
        System.out.println("time: " + base_time);
        System.out.println("date: " + base_date);
        System.out.println("nx " + String.valueOf(region.getNx()));
        System.out.println("ny " + String.valueOf(region.getNy()));
        System.out.println("-------------------------");

        Map<String, Object> response = new HashMap<>();
        response.put("coordinates", coordinates);
        response.put("weatherInfo", weatherInfo);

        return ResponseEntity.ok(coordinates);
    }

}
