package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hi")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }
    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam(value = "name") String name,Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping ("hello-string")
    @ResponseBody //http 에서 헤더부 바디부중 바디부에 이 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello" + name; // hello spring(name에 들어간거)
    }

    @GetMapping("hello-api")//제이슨 방식이라는데 key:value, key-name,
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name") String name) {
        Hello hello = new Hello();//객체만들기
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }// 프로퍼티 접근방식
    }


}