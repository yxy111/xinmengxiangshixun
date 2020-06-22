package cn.easybuy.controller;


import cn.easybuy.config.LuoYangException;
import cn.easybuy.pojo.News;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.service.impl.NewsServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Controller
@RequestMapping("/admin/news")
public class NewsController {

    @Autowired
    private NewsServiceImpl newsService;

    //新闻分页查询
    @GetMapping("allnew")
    public  String allnews(Integer currentPage, Model model)
    {
        Map<String, Object> map = newsService.queryNewsList(currentPage, 10);
        model.addAttribute("newsList", map.get("newsList"));
        model.addAttribute("pager", map.get("pager"));
        return  "/backend/news/newsList";

    }
    //新闻详情
    @GetMapping("getnoe")
    public  String getnoe(Integer id, Model model)
    {
        News news = newsService.getById(id);
        model.addAttribute("news", news);
        return  "/backend/news/newsDetail";

    }





}

