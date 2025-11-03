package com.example.springbootecscicd;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/demo")
public class TestController {
    @GetMapping("/data")
    public String getData(HttpServletRequest request, @RequestParam(required = false) String msg){
        String clientIp = request.getRemoteAddr();
        String response = "First message from AWS ECS";

        if (msg != null && !msg.isBlank()) {
            response += ",msg=" + msg + " ,clientIp=" + clientIp;
        }
        log.info("getData : remoteIP = {}", clientIp);
        log.info("getData : Response = {}", response);
        return response;
    }
}
