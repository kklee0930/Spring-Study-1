package study.springstudy1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.springstudy1.application.MemberServiceImple;
import study.springstudy1.domain.Member;

import java.util.List;

@Controller //Controller를 통해 Controller 객체를 생성하고 스프링 컨트롤러에 등록해준다.(Component Scan)
public class MemberController {

    private final MemberServiceImple memberService;

//    @Autowired //스프링 컨테이너에 있는 memberService를 가져온다. (의존성 주입)
    // MemberController가 생성이 될 때, 스프링 빈에 등록되어 있는 memberService를 가져다가 넣어준다.
    public MemberController(MemberServiceImple memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; //로 이동
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); //회원 목록을 가져온다.
        model.addAttribute("members", members); //model에 담아서 view에 넘긴다.
        return "members/memberList";

    }

}
