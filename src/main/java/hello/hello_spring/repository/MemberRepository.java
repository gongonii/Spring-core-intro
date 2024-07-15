package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//회원 저장소 저장
    Optional<Member> findById(Long id); //저장소에서 아이디 찾는거
    Optional<Member> findByName(String name); //Optional-null처리 방법 ,, 저장소에서 이름 찾는거
    List<Member> findAll(); //저장소에 저장되어있는 모든 데이터 찾기
}
