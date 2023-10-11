package com.ssafy.study.member.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String userRole;
    private Long memberNo; // 추가: 회원 번호 필드
    private String nickname; // 추가: 닉네임 필드

    // Getter, Setter 및 추가적인 메서드 정의

    // 이메일과 사용자 역할을 매개변수로 받아 Member 객체 생성하는 정적 팩토리 메서드
    public static Member create(String email, String userRole) {
        Member member = new Member();
        member.setEmail(email);
        member.setUserRole(userRole);
        return member;
    }
}