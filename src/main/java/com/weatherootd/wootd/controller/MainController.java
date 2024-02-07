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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/wootds")
public class MainController {

    private final MapService mapService;

    @Autowired
    public MainController (MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/wootds")
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
        }

        System.out.println("로그인한 사용자 정보 세션 저장 성공");
        return "main";
    }

    @GetMapping("/main")
    public String mainPage() {
        System.out.println("main 실행");
        return "main";
    }

    @GetMapping("/map")
    public String mapPage(Model model) {
        // 회원정보 내 주소 좌표값
        WeatherDTO defaultMap = mapService.getDefaultMap();

        List<WeatherDTO.item> items = defaultMap.getItems();

        if (defaultMap != null && defaultMap.getItems() != null && !defaultMap.getItems().isEmpty()) {
            WeatherDTO.item item = defaultMap.getItems().get(0);
            double latitude = item.getNx();
            double longitude = item.getNy();

            model.addAttribute("userLat", latitude);
            model.addAttribute("userLong", longitude);

            System.out.println("MainController " + latitude + " " + longitude);
        } else {
            System.out.println("MainController - null");
        }

        return "map";
    }


//    @GetMapping("/map")
//    public String naverAddress(Model model) {
//        String userAdd = mapService.naverAddress();
//        model.addAttribute("userAdd", userAdd);
//        return "map";
//    }

}
