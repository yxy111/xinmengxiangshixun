package cn.easybuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Stream;


/**
 * 登陆模块
 *
 * @author 李凤强
 */
@Controller
public class LoginRegistrationController {
    @GetMapping("login")
    public String login() {
        return "/pre/login";
    }

    @GetMapping("register")
    public String register() {
        return "/pre/register";
    }

}
