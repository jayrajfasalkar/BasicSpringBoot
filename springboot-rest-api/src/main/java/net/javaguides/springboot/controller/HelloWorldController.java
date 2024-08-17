package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //HTTP get request
    @GetMapping("/hello-world")
    public String sayHello() {
        return "Hello World";
    }
}
