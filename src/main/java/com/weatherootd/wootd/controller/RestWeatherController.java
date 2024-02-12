package com.weatherootd.wootd.controller;


import com.weatherootd.wootd.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wootds/main")
public class RestWeatherController {

    private RestTemplate restTemplate;

    @Autowired
    private MapService mapService;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public String getWeather(String weatherDate, String weatherTime, String dataType, String nx, String ny) {

    String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
        String serviceKey = "i16gKtFJ3wTw42INqN1DSDhnle6Ei4CZvm7hD2AzHpZxbQl9K9093cwKpqnDyR9Un1lC93P%2FnIpv9biDdWIGhQ%3D%3D";
        String base_date = weatherDate;
        String base_time = weatherTime;
        String numOfRows = "1";
        String pageNo = "1";

        String url = String.format("%s?serviceKey=%s&base_date=%s&base_time=%s&nx=%s&ny=%s&numOfRows=%s&pageNo=%s&dataType=%s",
                apiUrl, serviceKey, base_date, base_time, nx, ny, numOfRows, pageNo, dataType);

        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}
