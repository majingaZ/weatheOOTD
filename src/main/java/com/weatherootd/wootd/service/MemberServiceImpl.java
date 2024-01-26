package com.weatherootd.wootd.service;

import com.weatherootd.wootd.dto.MemberDTO;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.repository.MemberRepository;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean isIdDuplicated(String id) {
        return memberRepository.findById(id).isPresent();
    }

    @Override
    public void joinProcess(MemberDTO memberDTO) {
        System.out.println("joinProcess");
        if (!isValidMemberDTO(memberDTO)) {
            throw new IllegalArgumentException("Invalid member data");
        }

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
    private boolean isValidMemberDTO(MemberDTO memberDTO) {
        String id = memberDTO.getId();
        String password = memberDTO.getPass();
        if (id == null || password == null || id.length() < 6 || password.length() < 8) {
            return false;
        }

        if (!id.matches("[a-zA-Z]+") || !password.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        return true;
    }
}