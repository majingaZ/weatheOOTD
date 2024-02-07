package com.weatherootd.wootd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 지역 순번

    private String province; // 시, 도
    private String district; // 시, 군, 구
    private String township; // 동, 읍, 리
    private int nx; // x 좌표
    private int ny; // y 좌표
}