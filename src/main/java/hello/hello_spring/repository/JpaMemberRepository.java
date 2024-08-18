package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private EntityManager em; //jpa는 EntityManager로 모든게 동작한다

    @Override
    public Member save(Member member) {
        em.persist(member); //persist영구저장하다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class) // = : 동적할당 - 변화할 수 있는 값은
        .setParameter("name", name) // 뒤 네임에 값이 들어감
        .getResultList();
        return result.stream().findAny(); //result가 멤버로 된 리스트를 반환하겠다 / stream - 어려웡 ㅜㅜ
    }

    @Override
    public List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class)
                .getResultList();

    }
}
