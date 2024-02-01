package com.weatherootd.wootd.service;

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
    public boolean isIdDuplicated(String id) {
        Member member = memberRepository.findById(id);
        return member != null;
    }

    @Override
    public boolean isNickDuplicated(String nickname) {
        Member member = memberRepository.findByNickname(nickname);
        return member != null;
    }


}