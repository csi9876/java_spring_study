package com.ssafy.study.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SecurityUserDto {
    private Long memberNo;
    private String email;
    private String role;
    private String nickname;



}