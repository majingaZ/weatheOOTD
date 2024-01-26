package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(Model model) {
        System.out.println("join 실행");
        model.addAttribute("memberDTO", new MemberDTO());
        return "join";
    }

}
