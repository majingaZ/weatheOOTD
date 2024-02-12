package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.dto.WeatherDTO;
import com.weatherootd.wootd.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;

@Controller
@RequestMapping("/wootds/main")
public class MainController {

    private final MapService mapService;

    @Autowired
    public MainController (MapService mapService) {
        this.mapService = mapService;
    }


    @GetMapping
    public String main(Model model) {
    String id = SecurityContextHolder.getContext().getAuthentication().getName();
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        model.addAttribute("id", id);
        model.addAttribute("role", role);

        if (model.getAttribute(id) == null) {
            System.out.println("로그인한 사용자 정보 세션 저장 실패");
        } else {
            System.out.println("로그인한 사용자 정보 세션 저장 성공");
        }

        WeatherDTO weatherDTO = mapService.getDefaultMap();

        if (weatherDTO != null && !weatherDTO.getItems().isEmpty()) {
            model.addAttribute("nx", weatherDTO.getItems().get(0).getNx());
            model.addAttribute("ny", weatherDTO.getItems().get(0).getNy());
            System.out.println("MainController x 좌표: " + weatherDTO.getItems().get(0).getNx());
            System.out.println("MainController y 좌표: " + weatherDTO.getItems().get(0).getNy());
        } else {
            // 좌표를 찾지 못한 경우 기본값 설정
            model.addAttribute("nx", 37.57588);
            model.addAttribute("ny", 126.9768);
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
        String formattedDate = now.format(dateFormatter);
        String formattedTime = now.format(timeFormatter);

        model.addAttribute("nowDate", formattedDate);
        model.addAttribute("nowTime", formattedTime);

        return "main";
    }


}
