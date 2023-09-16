package repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.springstudy1.domain.Member;
import study.springstudy1.repository.MemberRepository;
import study.springstudy1.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach // 메소드가 끝날때마다 실행되는 콜백 메소드
    public void afterEach() {
        memberRepository.clearStore(); // store를 비워줌
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);
        // Optional<T> 이기 때문에 .get()으로 꺼내줘야함
        Member result = memberRepository.findById(member.getId()).get();
        // 저장값과 입력값이 가져온 값이 같은지 체크
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); // member가 result와 같은지 확인
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
