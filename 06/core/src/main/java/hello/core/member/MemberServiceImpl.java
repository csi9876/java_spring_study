package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component// 자동 등록하면 의존관계 주입은 어떻게 할 것인가   >> 13줄
public class MemberServiceImpl implements MemberService{
//    구현객체 선택
    private final MemberRepository memberRepository;

    // 생성자
    @Autowired // 자동 의존관계 주입 / ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    /// 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
