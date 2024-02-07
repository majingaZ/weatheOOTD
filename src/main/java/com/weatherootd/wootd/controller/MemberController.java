package com.weatherootd.wootd.controller;

import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.repository.MemberRepository;
import com.weatherootd.wootd.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wootds")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String join(Model model) {
        System.out.println("join 실행");
        model.addAttribute("memberDTO", new MemberDTO());
        return "join";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("login 실행");
        return "login";
    }

    @PostMapping("/joinProcess")
    public String processJoinForm(@Valid MemberDTO memberDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "join"; // 폼 다시 표시
        } else {
            Member data = Member.builder()
                    .role(memberDTO.getRole())
                    .id_type(memberDTO.getId_type())
                    .id(memberDTO.getId())
                    .pass(passwordEncoder.encode(memberDTO.getPass()))
                    .name(memberDTO.getName())
                    .nickname(memberDTO.getNickname())
                    .address(memberDTO.getAddress())
                    .birth(memberDTO.getBirth())
                    .email(memberDTO.getEmail())
                    .phone(memberDTO.getPhone())
                    .build();

            memberRepository.save(data);
            return "redirect:/wootds/login";
        }
    }

}