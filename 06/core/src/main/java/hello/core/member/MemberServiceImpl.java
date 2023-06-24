package hello.core.member;

public class MemberServiceImpl implements MemberService{
//    구현객체 선택
    private final MemberRepository memberRepository;

    // 생성자
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
}
