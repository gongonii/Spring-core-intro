package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 저장소?
    private static long sequence = 0L; //sequence = 0,1,2처럼 키값을 생성해주는 변수,, 실무에서는 동시성 문제 고려해야함 그래서 Atomic,Long으로 해야하긴함


    @Override
    public Member save(Member member) {
        member.setId(++sequence); //스토어에다가 넣기 전에 멤버에 id값을 세팅해주고 이름은 세이브하기 전 이름은 넘어온 상태 id는 시스템이 정해주는거
        store.put(member.getId(), member);//스토어에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {     //스토어에서 꺼내면 됨 스토어에 get해서 id를 넣으면 됨
        return Optional.ofNullable(store.get(id)); //Optional로 감싸면 ~~null인 상황에도 ㄱㅊ
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 멤버에서 member.getName이 여기 파라미터로 넘어온 Name과 같은지 확인, 같은경우에만 필터링
                .findAny(); //하나라도 찾는것 //결과가 옵셔널로 반환,, 끝까지 없으면 Optional에 null이 포함돼서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());// store.value = 스토어에 있는 벨류가 멤버를 뜻함
    }

    public void clearStore(){
        store.clear(); //  store비움


    }
}
//이게 잘 실행하는지 어케아냐? test 케이스를 만들어 주면 됨