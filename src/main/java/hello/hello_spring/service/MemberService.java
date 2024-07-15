package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {


    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;// 멤버 서비스를 멤버 리포지토리를 직접 내가 new에서 생성하는게 아니라 외부에서 넣어주도록 함
    }

    //회원가입

    public Long join(Member member) {   //join을 하면 중복회원 검증하고 통과하면 저장한다
        //같은이름이 있는 중복회원은 x
        validataDuplicateMember(member);
        memberRepository.save(member);
        return member.getId(); //아이디만 반환해주겠다

    }
    //검증하는 메소드
    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//command+option+v => optional 자동 삽입
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");//if present= null이 아니라 어떤 값이 있으면 throw~~ 로직이 동작을 함(optional이기 때문에 가능한 것 )
            });
    }
    public List<Member> findMembers(){ //MemberRepository에서  findAll()의 반환타입 List<Member>이다
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
//전체회원 조회하는 기능

