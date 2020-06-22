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

    @GetMapping("allnew")
    public  String allnews(Integer currentPageNo, Model model)
    {
        try{
            System.out.println("11111111");
            Page<News> page = new Page<>(currentPageNo, 10);
            newsService.page(page,null);
            List<News> newsList = page.getRecords();
            System.out.println(newsList.toString());
            long total = page.getTotal();
            Pager pager=new Pager(total,10,currentPageNo);

            model.addAttribute("newsList", newsList);
            model.addAttribute("pager", pager);

        }catch (Exception e)
        {
            System.out.println(e.getMessage()+"111111111");
        }


        return "/backend/news/newsList";

    }

}

