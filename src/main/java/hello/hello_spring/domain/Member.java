package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //db가 알아서 생성해주는 것은 identity 라고 하면 됨
    private long id; //자바에서는 long 이지만 db 에서는 bigint 라는 타입

    //@Column(name = "username" ) //"" 안에 들어갈 말은 컬럼명
    private String name;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
