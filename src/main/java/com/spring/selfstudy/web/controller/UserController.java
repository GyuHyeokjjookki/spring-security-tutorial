package com.spring.selfstudy.web.controller;

import com.spring.selfstudy.service.UserService;
import com.spring.selfstudy.web.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUpForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(UserVo userVo){
        userService.joinUser(userVo);
        return "redirect:/login";
    }

    @GetMapping
    public String root(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/access_denied")
    public String accessDenied(){
        return "access_denied";
    }

    @GetMapping("/user_access")
    public String UserAccess(Model model, Authentication authentication){
        UserVo userVo = (UserVo) authentication.getPrincipal();
        model.addAttribute("info", userVo.getUserId() + "의 " + userVo.getUsername() + "님");
        return "user_access";
    }

}
