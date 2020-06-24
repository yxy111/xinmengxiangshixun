package cn.easybuy.controller;


import cn.easybuy.pojo.Product;
import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.pojo.User;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.service.ProductService;
import cn.easybuy.utils.ReturnResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    //分页查询商品信息
    @GetMapping("list")
    public String hello(Model model, @RequestParam(required = false) Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        Page<Product> page = new Page<>(currentPage, 5);
        productService.page(page, null);
        List<Product> list = page.getRecords();
        Pager pager = new Pager(page.getPages(), 5, currentPage, "product/list?");
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        return "/backend/product/productList";
    }

    //删除一个商品
    @ResponseBody
    @GetMapping("deleteOneProduct/{id}")
    public ReturnResult deleteOneProduct(@PathVariable Integer id) {
        boolean b = productService.removeById(id);
        return ReturnResult.success("删除成功");
    }

    //商品信息回显
    @GetMapping("huixian/{id}")
    public String deleteOneProduct(@PathVariable Integer id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);

        //一级分类
        QueryWrapper<ProductCategory> categoryQueryWrapper1 = new QueryWrapper<>();
        categoryQueryWrapper1.eq("type", 1);
        List<ProductCategory> productCategoryList1 = productCategoryService.list(categoryQueryWrapper1);
        model.addAttribute("productCategoryList1", productCategoryList1);

        //一级分类
        QueryWrapper<ProductCategory> categoryQueryWrapper2 = new QueryWrapper<>();
        categoryQueryWrapper2.eq("type", 2);
        List<ProductCategory> productCategoryList2 = productCategoryService.list(categoryQueryWrapper2);
        model.addAttribute("productCategoryList2", productCategoryList2);
        //一级分类
        QueryWrapper<ProductCategory> categoryQueryWrapper3 = new QueryWrapper<>();
        categoryQueryWrapper3.eq("type", 3);
        List<ProductCategory> productCategoryList3 = productCategoryService.list(categoryQueryWrapper3);
        model.addAttribute("productCategoryList3", productCategoryList3);

        return "/backend/product/toAddProduct";
    }

    //商品修改或添加
    @PostMapping("addorupdate")
    public String addorupdate(Product product, MultipartFile photo, HttpServletRequest request) {

        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(photo.getOriginalFilename());
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("/files");
        System.out.println(url);
        //以绝对路径保存重名命后的图片
        try {
            photo.transferTo(new File(url + "/" + name + "." + ext));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //把图片存储路径保存到数据库
        product.setFileName(name + "." + ext);

        if (product.getId() != null) {
            //修改
            productService.updateById(product);
        } else {
            //添加
            productService.save(product);
        }
        return "redirect:/product/list";
    }

    //跳转到商品上架页
    @GetMapping("add")
    public String toaddpage(Model model) {
        //1级分类
        QueryWrapper<ProductCategory> categoryQueryWrapper1 = new QueryWrapper<>();
        categoryQueryWrapper1.eq("type", 1);
        List<ProductCategory> productCategoryList1 = productCategoryService.list(categoryQueryWrapper1);
        model.addAttribute("productCategoryList1", productCategoryList1);

        //2级分类
        QueryWrapper<ProductCategory> categoryQueryWrapper2 = new QueryWrapper<>();
        categoryQueryWrapper2.eq("type", 2);
        List<ProductCategory> productCategoryList2 = productCategoryService.list(categoryQueryWrapper2);
        model.addAttribute("productCategoryList2", productCategoryList2);
        //3级分类
        QueryWrapper<ProductCategory> categoryQueryWrapper3 = new QueryWrapper<>();
        categoryQueryWrapper3.eq("type", 3);
        List<ProductCategory> productCategoryList3 = productCategoryService.list(categoryQueryWrapper3);
        model.addAttribute("productCategoryList3", productCategoryList3);
        return "/backend/product/toAddProduct";
    }

    /**
     * 根据id查看商品详情
     * 作者：李凤强
     *
     * @param id    商品id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public String product(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
        List<ProductCategoryVo> vos = productCategoryService.queryAllProductCategoryList();
        model.addAttribute("product", product);
        model.addAttribute("productCategoryVoList", vos);
        return "/pre/product/productDeatil";
    }

    /**
     * 按分类查询所有商品
     * 作者：李凤强
     *
     * @param category 分类id
     * @param level    分类级别
     * @param model
     * @return
     */
    @GetMapping
    public String all(Integer category, Integer level, Model model) {
        List<Product> products = productService.getProductList(category, level);
        List<ProductCategoryVo> vos = productCategoryService.queryAllProductCategoryList();
        model.addAttribute("total", products.size());
        model.addAttribute("productList", products);
        model.addAttribute("productCategoryVoList", vos);
        return "/pre/product/queryProductList";
    }

    /**
     * 按商品名模糊搜索商品
     * 作者：李凤强
     *
     * @param keyWord 搜索关键字
     * @param model
     * @return
     */
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

