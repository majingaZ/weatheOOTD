package com.weatherootd.wootd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/wootds")
public class MainController {

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

}
