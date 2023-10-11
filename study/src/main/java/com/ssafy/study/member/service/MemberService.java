package com.ssafy.study.member.service;

import com.ssafy.study.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {

    // 실제로는 Repository를 주입받아서 데이터베이스와 상호작용해야 합니다.
    // 이 예시에서는 단순히 임시 데이터를 사용하도록 하겠습니다.
    private final Map<String, Member> memberData = new HashMap<>();

    public Optional<Member> findByEmail(String email) {
        // 이메일을 기준으로 회원 정보 조회하는 로직 작성

        // 임시 데이터에서 이메일을 키로 회원 정보 조회
        Member member = memberData.get(email);

        return Optional.ofNullable(member);
    }

    // 추가적인 메서드 및 로직 구현

}