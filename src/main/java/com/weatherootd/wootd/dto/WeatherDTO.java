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
        private String baseDate; // 발표 일자
        private String baseTime; // 발표 시각
        private String lastUpdate; // 마지막 업데이트 시간
        private double pop; // 강수확률
        private int pty; // 강수형태
        private double pcp; // 1시간 강수량
        private double reh; // 습도
        private double sno; // 1시간 신적설
        private double tmp; // 1시간 기온
        private double tmn; // 일 최저기온
        private double tmx; // 일 최고기온
        private String category;
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
