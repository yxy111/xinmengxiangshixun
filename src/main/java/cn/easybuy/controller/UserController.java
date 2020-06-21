package cn.easybuy.controller;


import cn.easybuy.pojo.User;
import cn.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("list")
    public String hello(Model model)
    {

        List<User> userList = userService.getUserList(1, 10);
        model.addAttribute("userList", userList);
        return "backend/user/userList";
    }

}

