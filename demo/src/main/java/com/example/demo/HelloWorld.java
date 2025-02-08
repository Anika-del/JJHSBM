package com.example.demo;
import org.springframework.web.bind.annotation.*;


    @RestController
    public class HelloWorld {

        @GetMapping("abc")
        public String sayHello() {
            return "Hello Demo Class";
        }
    }


