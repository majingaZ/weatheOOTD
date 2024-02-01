package com.weatherootd.wootd.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.weatherootd.wootd.controller.WeatherDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class WeatherDTO {

    private List<item> items;

    public void setItems(List<item> items) {
        this.items = items;
    }
    public List<item> getItems() {
        return items;
    }

    public void setItem (item item) {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonDeserialize(using = WeatherDeserializer.class)
    public static class items {
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
        private int nx;
        private int ny;

        public void setNx (int nx) {
            this.nx = nx;
        }

        public void setNy (int ny) {
            this.ny = ny;
        }
    }

}
