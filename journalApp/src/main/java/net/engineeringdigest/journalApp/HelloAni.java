package net.engineeringdigest.journalApp;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloAni {

        @GetMapping("demo")
        public String sayHello() {
            return "Hello Demo Class";
        }
    }


