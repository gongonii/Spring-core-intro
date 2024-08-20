package hello.hello_spring.service;

import hello.hello_spring.repository.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    /*private DataSource dataSource; //SpringBoot가 설정해놓은 설정파일을 보고 자체적으로 bin도 생성해줌

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
         //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);


    }
}
