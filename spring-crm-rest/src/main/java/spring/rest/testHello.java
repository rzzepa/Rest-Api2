package spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testHello {

    @GetMapping("/hello")
    public String Hello()
    {
        return "Hello";
    }

    }
