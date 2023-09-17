package study.springstudy1.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.springstudy1.domain.Member;
import study.springstudy1.infrastructure.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImpleTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach // 테스트 실행할 때마다 실행되는 콜백 메소드
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImple(memberRepository);
    }

    @AfterEach // 끝날 때마다 db에 저장된 값을 날림
    public void afterEach() {
        memberRepository.clearStore();
    }

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

    @Test
    void 유저모두조회하기() {
    }

    @Test
    void 유저한명조회하기() {
    }
}