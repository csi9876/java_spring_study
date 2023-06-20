package hello.core.discount;
import hello.core.member.Grade;
import hello.core.member.Member;
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10% 할인
//    ctrl shift T 하면 테스트 생성
    @Override
    public int discount(Member member, int price) {
//        vip인 경우 10% 할인
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}