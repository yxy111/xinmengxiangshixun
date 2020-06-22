package cn.easybuy.controller;


import cn.easybuy.pojo.Product;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
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

    @GetMapping("{id}")
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

