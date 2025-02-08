package com.example.demo;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloDemo {

    @GetMapping("demo")
    public String sayHello() {
        return "Hello Demo Class";
    }
}


