package com.weatherootd.wootd.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.weatherootd.wootd.controller.WeatherDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class WeatherDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonDeserialize(using = WeatherDeserializer.class)
    public static class items{
        private List<item> item;
    }

    @Getter
    @NoArgsConstructor
    public static class item{
        private String baseDate;
        private String baseTime;
        private String category;
        private String fcstDate;
        private String fcstTime;
        private String fcstValue;
        private Long nx;
        private Long ny;
    }
}
