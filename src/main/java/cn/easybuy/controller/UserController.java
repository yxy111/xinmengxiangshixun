package cn.easybuy.controller;


import cn.easybuy.pojo.User;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    //分页查询用户信息
    @GetMapping("list")
    public String hello(Model model,Integer currentPage)
    {
        List<User> userList = userService.getUserList(currentPage, 10);
        Pager pager = new Pager(1, 10, currentPage,"admin/user/list?");
        model.addAttribute("userList", userList);
        model.addAttribute("pager", pager);
        return "backend/user/userList";
    }
    //根据id删除用户
    @GetMapping ("delete")
    public String deleById(@RequestParam(value = "id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/admin/user/list";
    }

    // 查询用户信息 跳转到用户修改页面
    @GetMapping ("updatepage")
    public String updatepage(@RequestParam(value = "id") Integer id,Model model) {
        User user = userService.getUser(id, "");
        model.addAttribute("user", user);
        return "/backend/user/toUpdateUser";
    }

    //根据id修改用户信息 或者添加用户
    @PostMapping("updeteuser")
    public String updeteuser(User user) {
        if(user.getId()!=null)
        {
            userService.update(user);
        }
        else{
            userService.add(user);
        }
        return "redirect:/admin/user/list";
    }

    //添加用户 跳转到用户添加页面
    @GetMapping ("AddUser")
    public String AddUser(Model model) {
        return "/backend/user/toUpdateUser";
    }

    //查询单个用户
    @GetMapping ("getone")
    public String getone(Model model) {
        return "/backend/user/userInfo";
    }
}

