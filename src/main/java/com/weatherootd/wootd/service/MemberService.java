package com.weatherootd.wootd.service;

import com.weatherootd.wootd.dto.MemberDTO;

public interface MemberService {

    boolean isIdDuplicated(String id);

    void joinProcess(MemberDTO memberDTO);
}