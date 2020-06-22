package cn.easybuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李凤强
 */
@Controller
public class IndexController {
    @GetMapping({"/", "index"})
    public String index() {
        return "/index";
    }
}
