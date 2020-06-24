package cn.easybuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李凤强
 * @since 2020--6-22
 */
@Controller
public class IndexController {
    /**
     * 访问根路径或index页面
     *
     * @return
     */
    @GetMapping({"/", "index"})
    public String index() {
        return "/index";
    }
}
