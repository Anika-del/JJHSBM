package com.usermanagement;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("abc")
    public String sayHello() {
        return "Hello Ani World !!";
    }
}
