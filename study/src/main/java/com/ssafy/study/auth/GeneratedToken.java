package com.ssafy.study.auth;

public class GeneratedToken {
    private String accessToken;
    private String refreshToken;

    // 생성자 추가
    public GeneratedToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // Getter, Setter 및 추가적인 메서드 정의

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
