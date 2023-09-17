package study.springstudy1.application;

import study.springstudy1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public Long join(Member member);
    public List<Member> findMembers();
    public Optional<Member> findOneUser(Long memberId);
}
