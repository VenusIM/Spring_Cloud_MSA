package com.msa.userservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("/")
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final Environment environment;

    @GetMapping("first-service/welcome")
    public String welcome1() {
        return "welcome to first service";
    }

    @GetMapping("second-service/welcome")
    public String welcome2() {
        return "welcome to second service";
    }

    @GetMapping("first-service/message")
    public String message1(@RequestHeader("first-request") String header) {
        log.info(header);
        return "first service message";
    }

    @GetMapping("second-service/message")
    public String message2(@RequestHeader("second-request") String header) {
        log.info(header);
        return "second service message";
    }

    @GetMapping("first-service/check")
    public String check1(HttpServletRequest request) {
        log.info("Server port = {}", request.getServerPort());
        return String.format("Environment Server port %s", environment.getProperty("local.server.port"));
    }

    @GetMapping("second-service/check")
    public String check2() {
        return "second service check";
    }
}
