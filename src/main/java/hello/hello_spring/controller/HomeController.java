package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //도메인 첫번째 로컬호스트 8080으로 들어오면 10~13 호출, home.html 호출
    public String home() {
        return "home";
    }


}
