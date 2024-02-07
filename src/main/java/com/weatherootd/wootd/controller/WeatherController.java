package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/wootd")
public class WeatherController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/map")
    public String weatherInfo(Model model) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
        String formattedDate = now.format(dateFormatter);
        String formattedTime = now.format(timeFormatter);

        model.addAttribute("nowDate", formattedDate);
        model.addAttribute("nowTime", formattedTime);

        return "map";
    }

}
