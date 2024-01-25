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

    @PostMapping("/joinProc")
    public String joinProcess(@Valid @ModelAttribute("memberDTO") MemberDTO memberDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            System.out.println("유효성 검사 이상 있음 - join 재실행");
            return "join";
        } else {
            System.out.println("가입 아이디: " + memberDTO.getId());
            memberService.joinProcess(memberDTO);
            System.out.println("유효성 검사 이상 없음 - login 실행");
            return "redirect:/login";
        }
    }
}
