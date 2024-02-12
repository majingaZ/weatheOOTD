package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/wootds")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public String list() {
        return "list";
    }
}
