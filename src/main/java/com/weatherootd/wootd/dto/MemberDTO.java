package com.weatherootd.wootd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
    private String role;
    private String id;
    private String id_type;
    private String pass;
    private String name;
    private String nickname;
    private String address;
    private String birth;
    private String email;
    private String phone;
}
