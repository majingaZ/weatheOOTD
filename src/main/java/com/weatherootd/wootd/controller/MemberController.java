package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(MemberDTO memberDTO) {
        System.out.println("가입 아이디: " + memberDTO.getId());
        memberService.joinProcess(memberDTO);
        return "redirect:/login";
    }
}
