package com.weatherootd.wootd.service;

import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public MemberServiceImpl (MemberRepository memberRepository, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void joinProcess (MemberDTO memberDTO) {
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
    }
}
