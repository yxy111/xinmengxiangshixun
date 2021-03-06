package cn.easybuy.controller;

import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.NewsService;
import cn.easybuy.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李凤强
 * @since 2020-06-22
 */
@Controller
@RequestMapping("home")
public class HomeController {
    @Resource
    ProductCategoryService productCategoryService;

    @Resource
    NewsService newsService;

    /**
     * 访问主页
     *
     * @param model
     * @return
     */
    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("productCategoryVoList", productCategoryService.queryAllProductCategoryList());
        model.addAttribute("news", newsService.list());
        return "/pre/index";
    }
}
