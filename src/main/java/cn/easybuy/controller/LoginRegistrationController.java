package cn.easybuy.controller;

import cn.easybuy.pojo.User;
import cn.easybuy.service.UserService;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.SecurityUtils;
import cn.easybuy.utils.ShoppingCart;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.stream.Stream;


/**
 * 登陆模块
 *
 * @author 李凤强
 */
@Controller
public class LoginRegistrationController {
    @Resource
    UserService userService;

    @GetMapping("login")
    public String login() {
        return "/pre/login";
    }

    @GetMapping("register")
    public String register() {
        return "/pre/register";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.removeAttribute("cart");
        return "redirect:/login";
    }

    @ResponseBody
    @PostMapping("login")
    public ReturnResult login(String loginName, String password, HttpSession session) {
        User user = userService.login(loginName, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            session.setAttribute("cart", new ShoppingCart());
            return ReturnResult.success("登陆成功");
        }
        return ReturnResult.err("登陆失败，用户名或密码错误");
    }

    @ResponseBody
    @PostMapping("register")
    public ReturnResult register(User user) {
        return userService.register(user);
    }
}
