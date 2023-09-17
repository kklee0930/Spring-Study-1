package study.springstudy1.application;

import study.springstudy1.domain.Member;
import study.springstudy1.infrastructure.MemberRepository;
import study.springstudy1.infrastructure.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberServiceImple implements MemberService{ // ctrl + shift + t로 테스트 코드 생성 가능
    private final MemoryMemberRepository memberRepository;

    public MemberServiceImple(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 X
        validateUserName(member); // ctrl + alt + m을 하면 extract method 기능 사용이 가능하다.

        memberRepository.save(member);
        return member.getId();
    }

    // 중복 가입 방지
    private void validateUserName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 특정 회원 조회
     */
    public Optional<Member> findOneUser(Long memberId) {
        return memberRepository.findById(memberId);
    }
}