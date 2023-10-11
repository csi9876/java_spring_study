package com.ssafy.study.member.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseStatus {
    private int status;
    private String accessToken;

    // Getter, Setter 및 추가적인 메서드 정의

    public static TokenResponseStatus addStatus(int status, String accessToken) {
        TokenResponseStatus responseStatus = new TokenResponseStatus();
        responseStatus.setStatus(status);
        responseStatus.setAccessToken(accessToken);
        return responseStatus;
    }

    // Getter, Setter 등 추가적인 메서드 정의

}