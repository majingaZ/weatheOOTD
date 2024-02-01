package com.weatherootd.wootd.service;


import com.weatherootd.wootd.dto.CustomUserDetails;
import com.weatherootd.wootd.entity.Member;
import com.weatherootd.wootd.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername (String id) throws UsernameNotFoundException {
        Member userData = memberRepository.findById(id);
        if (userData == null) {
            throw new UsernameNotFoundException("ERROR - " + id + " 유저 정보 없음");
        }
        return new CustomUserDetails(userData);
    }
}
