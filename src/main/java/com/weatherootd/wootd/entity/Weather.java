package com.weatherootd.wootd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Weather {

    @Id
    private Long region_id;

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
}
