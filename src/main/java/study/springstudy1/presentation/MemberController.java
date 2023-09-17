package study.springstudy1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.springstudy1.application.MemberServiceImple;

@Controller //Controller를 통해 Controller 객체를 생성하고 스프링 컨트롤러에 등록해준다.
public class MemberController {

    private final MemberServiceImple memberService;

    @Autowired //스프링 컨테이너에 있는 memberService를 가져온다. (의존성 주입)
    // MemberController가 생성이 될 때, 스프링 빈에 등록되어 있는 memberService를 가져다가 넣어준다.
    public MemberController(MemberServiceImple memberService) {
        this.memberService = memberService;
    }


}
