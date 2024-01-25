package com.weatherootd.wootd.service;

import com.weatherootd.wootd.dto.MemberDTO;

public interface MemberService {
    boolean duplicateId(String id);
    boolean duplicateNick(String nickname);

    void joinProcess(MemberDTO memberDTO);
}