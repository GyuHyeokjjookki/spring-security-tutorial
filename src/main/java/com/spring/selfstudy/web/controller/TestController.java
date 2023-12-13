package com.spring.selfstudy.web.controller;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello(String name, Model model) {
        model.addAttribute("name", name);
        logger.info("{} => {}", "name", name);
        //html 이름
        return "hello";
    }
}