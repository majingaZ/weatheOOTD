package com.weatherootd.wootd.controller;


import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.repository.MemberRepository;
import com.weatherootd.wootd.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class RestMemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/checkDuplicateId")
    public ResponseEntity<Map<String, Object>> checkDuplicateId(@RequestParam("id") String id) {
        Map<String, Object> response = new HashMap<>();
        if (memberService.isIdDuplicated(id)) {
            response.put("message", "사용 중인 아이디입니다.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else {
            response.put("message", "사용 가능한 아이디입니다.");
            return ResponseEntity.ok().body(response);
        }
    }
}