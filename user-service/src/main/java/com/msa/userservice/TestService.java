package com.msa.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestService {
    @GetMapping("first-service/welcome")
    public String welcome1() {
        return "welcome to first service";
    }

    @GetMapping("second-service/welcome")
    public String welcome2() {
        return "welcome to second service";
    }
}
