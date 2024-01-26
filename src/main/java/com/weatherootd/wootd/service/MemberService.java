package com.weatherootd.wootd.service;


public interface MemberService {

    boolean isIdDuplicated(String id);

    boolean isNickDuplicated(String nickname);
}