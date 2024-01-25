package com.weatherootd.wootd.controller;


import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class RestMemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/idCheck")
    public Map<String, Object> idCheck (@RequestBody MemberDTO memberDTO) {
        String userId = memberDTO.getId();
        boolean idDuplicate = memberService.duplicateId(userId);

        Map<String, Object> response = new HashMap<>();
        response.put("duplicateID", idDuplicate);

        return response;
    }

    @PostMapping("/nickCheck")
    public Map<String, Object> nickCheck (@RequestBody MemberDTO memberDTO) {
        String userNick = memberDTO.getNickname();
        boolean nickDuplicate = memberService.duplicateNick(userNick);

        Map<String, Object> response = new HashMap<>();
        response.put("duplicateNick", nickDuplicate);

        return response;
    }
}
