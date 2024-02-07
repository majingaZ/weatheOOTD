package com.weatherootd.wootd.service;

import com.weatherootd.wootd.dto.CustomUserDetails;
import com.weatherootd.wootd.dto.WeatherDTO;
import com.weatherootd.wootd.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MapService {

    @Autowired
    private RegionRepository regionRepository;
    private static final int DEFAULT_NX = 0;
    private static final int DEFAULT_NY = 0;

    // 네이버 지도용 주소
    public String naverAddress() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userAdd = ((CustomUserDetails) authentication.getPrincipal()).getAddress();
        System.out.println("MapService 전체 주소: " + userAdd);

        return userAdd;
    }

    // 기상청용 좌표
    public WeatherDTO getDefaultMap() {
        // Spring Security에서 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증 정보에서 주소값 가져오기
        String address = ((CustomUserDetails) authentication.getPrincipal()).getAddress();

        String township = addressParser(address);
        List<Object[]> regions = regionRepository.findByTownship(township);

        System.out.println("MapService 주소: " + township);

        WeatherDTO weatherDTO = new WeatherDTO();
        if (!regions.isEmpty()) {
            WeatherDTO.item item = new WeatherDTO.item();
            Object[] regionData = regions.get(0);
            item.setNx((Integer) regionData[0]);
            item.setNy((Integer) regionData[1]);
            weatherDTO.setItems(Arrays.asList(item));
            System.out.println("MapService 좌표 x: " + regionData[0]);
            System.out.println("MapService 좌표 y: " + regionData[1]);
            return weatherDTO;
        } else {
            return getDefaultMapAddress();
        }
    }

    private String addressParser(String address) {
        String[] parts = address.split(" ");
        return parts[parts.length -1];
    }

    private WeatherDTO getDefaultMapAddress() {
        WeatherDTO weatherDTO = new WeatherDTO();
        WeatherDTO.item item = new WeatherDTO.item();
        item.setNx((int) DEFAULT_NX);
        item.setNy((int) DEFAULT_NY);
        weatherDTO.setItem(item);
        return weatherDTO;
    }
}
