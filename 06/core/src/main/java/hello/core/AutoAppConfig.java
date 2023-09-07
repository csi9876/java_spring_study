package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정정보
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 스프링 빈 자동 등록, Configuration 붙은 건 제외
public class AutoAppConfig {

    // 수동 빈 등록과 자동 빈 등록이 충돌하면 수동 빈이 우선권을 가진다 > 이제는 에러나게 만들어줬음
//    @Bean(name="memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
