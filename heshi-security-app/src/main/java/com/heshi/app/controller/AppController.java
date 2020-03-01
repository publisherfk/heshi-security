package com.heshi.app.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

    @GetMapping("/method1")
    @ResponseBody
    public String method1() {
        return "method1()";
    }

    @GetMapping("/method2")
    @ResponseBody
    public String method2() {
        return "method2()";
    }

    @GetMapping("/method3")
    @ResponseBody
    public User method3(@AuthenticationPrincipal User user) {
        return user;
    }
}
