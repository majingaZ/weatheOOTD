package com.weatherootd.wootd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
@RequiredArgsConstructor
@RequestMapping("/wootds")
public class MainController {

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
        return "/main";
    }

    @GetMapping("/main")
    public String mainPage() {
        System.out.println("main 실행");
        return "main";
    }

    @GetMapping("/map")
    public String mapTest() {
        return "map";
    }

}
