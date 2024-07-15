package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired //멤버서비스를 스프링 컨테이너에 있는 멤버서비스를 가져다가 연결을 시켜주는 역할
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } //생성자를 만들어준다.


    //private final MemberService memberService = new MemberService(); //하나로 생성하고 공통으로 사용해도 된다. 그럴려면 스프링 컨테이너에 등록을 하면 됨. 그게 바로 밑에 방식
   // @Autowired  private final MemberService memberService; 필드 주입은 바꿀 수 없다는 단점,

    //@Autowired //setter Injection방식 단점- 누군가가 멤버 컨트롤을 호출했을 때 퍼블릭으로 열려있어야함
    //public void setMemberService(MemberService memberService) {
    //    this.memberService = memberService;
    //}

    @GetMapping("/members/new")
    public String createform() {
        return "members/creatememberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";//회원가입이 끝나면 홈화면으로 보내기 "/"이게 홈화면
    }




}
