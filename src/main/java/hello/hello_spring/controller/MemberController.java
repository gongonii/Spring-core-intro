package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //private final MemberService memberService = new MemberService(); //하나로 생성하고 공통으로 사용해도 된다. 그럴려면 스프링 컨테이너에 등록을 하면 됨. 그게 바로 밑에 방식
    private final MemberService memberService;

    @Autowired //멤버서비스를 스프링 컨테이너에 있는 멤버서비스를 가져다가 연결을 시켜주는 역할
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } //생성자를 만들어준다.





}
