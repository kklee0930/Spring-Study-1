package study.springstudy1.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.springstudy1.domain.Member;
import study.springstudy1.infrastructure.MemoryMemberRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 데이터를 롤백해준다. 즉 반영했던 데이터가 모두 지워진다. Test에만 적용되고 서비스에 붙게 되면 더티체킹을 진행한다.
class MemberServiceIntegrationTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @Test
    void 회원가입() {

        //given(주어진 상황, 이 데이터를 기반으로)
        Member member = new Member();
        member.setName("spring");

        //when(이 것을 검증해야함)
        Long saveId = memberService.join(member);

        //then
        Member member1 = memberService.findOneUser(saveId).get();
        Assertions.assertThat(member1.getName()).isEqualTo(member.getName());
    }

    @Test
    public void 중복회원예외() {

        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e =
                assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // 예외가 발생해야함
//        memberService.join(member2);
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then

    }
}