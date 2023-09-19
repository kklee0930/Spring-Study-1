package study.springstudy1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springstudy1.application.MemberServiceImple;
import study.springstudy1.infrastructure.MemberRepository;
import study.springstudy1.infrastructure.MemoryMemberRepository;

@Configuration // 스프링 빈 직접 등록해주기
public class SpringConfig {
//    @Bean
//    public MemberServiceImple memberService() {
//        return new MemberServiceImple(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
