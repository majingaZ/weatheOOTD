package com.weatherootd.wootd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherootd.wootd.dto.WeatherDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class WeatherService {

    public void getWeatherInfo(String baseDate, String baseTime, String nx, String ny) {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());

        WeatherDTO.items response;
        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?"
                + "serviceKey=i16gKtFJ3wTw42INqN1DSDhnle6Ei4CZvm7hD2AzHpZxbQl9K9093cwKpqnDyR9Un1lC93P%2FnIpv9biDdWIGhQ%3D%3D&numOfRows=10&pageNo=1&base_date=20210628&base_time=0500&nx=55&ny=127"
                + "&base_date=" + baseDate
                + "&base_time=" + baseTime
                + "&nx=" + nx
                + "&ny=" + ny;

        try {
            ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            response = objectMapper.readValue(result.getBody(), WeatherDTO.items.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ToStringBuilder.reflectionToString(response));
    }

}
