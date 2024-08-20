package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> , MemberRepository {

    @Override
    Optional<Member> findByName(String name);

}
//인터페이스가 인터페이스를 받을때는 extends 라고함