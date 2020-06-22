package cn.easybuy.controller;


import cn.easybuy.pojo.Product;
import cn.easybuy.pojo.User;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.service.ProductService;
import cn.easybuy.utils.ReturnResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author 罗阳
 * @since 2020-06-20
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;
    @Resource
    ProductCategoryService productCategoryService;

    //分页查询商品信息
    @GetMapping("list")
    public String hello(Model model, @RequestParam(required = false) Integer currentPage)
    {
        if (currentPage == null) {
            currentPage=1;
        }
        Page<Product> page = new Page<>(currentPage, 5);
        productService.page(page,null);
        List<Product> list = page.getRecords();
        Pager pager = new Pager(page.getPages(), 5, currentPage,"product/list?");
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        return "/backend/product/productList";
    }
    //删除一个商品
    @ResponseBody
    @GetMapping("deleteOneProduct/{id}")
    public ReturnResult deleteOneProduct(@PathVariable Integer id)
    {
        System.out.println("11111111111111111");
        boolean b = productService.removeById(id);
        return ReturnResult.success("删除成功");
    }

    @PostMapping("{id}")
    public String product(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
        List<ProductCategoryVo> vos = productCategoryService.queryAllProductCategoryList();
        model.addAttribute("product", product);
        model.addAttribute("productCategoryVoList", vos);
        return "/pre/product/productDeatil";
    }

    @GetMapping
    public String all(Integer category, Integer level, Model model) {
        List<Product> products = productService.getProductList(category, level);
        List<ProductCategoryVo> vos = productCategoryService.queryAllProductCategoryList();
        model.addAttribute("total", products.size());
        model.addAttribute("productList", products);
        model.addAttribute("productCategoryVoList", vos);
        return "/pre/product/queryProductList";
    }

    @GetMapping("search")
    public String search(String keyWord, Model model) {
        List<ProductCategoryVo> vos = productCategoryService.queryAllProductCategoryList();
        List<Product> products = productService.selectProductByFuzzyName(keyWord);
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("productCategoryVoList", vos);
        model.addAttribute("total", products.size());
        model.addAttribute("productList", products);
        return "/pre/product/queryProductList";
    }
}

