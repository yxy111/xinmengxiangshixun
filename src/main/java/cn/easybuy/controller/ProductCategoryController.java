package cn.easybuy.controller;


import cn.easybuy.mapper.ProductCategoryMapper;
import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.pojo.Product;
import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.utils.ReturnResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 *
 * <b>
 * 商品分类管理模块
 * 最后一次修改：李凤强
 * 2020年6月23日
 * </b>
 */
@Controller
@RequestMapping("/product-category")
public class ProductCategoryController {
    @Resource
    ProductCategoryMapper productCategoryMapper;

    @Resource
    ProductMapper productMapper;

    /**
     * 分页查询所以商品分类
     *
     * @param model
     * @param currentPage 当前页码
     * @return
     */
    @GetMapping("list")
    public String list(Model model, @RequestParam(required = false) Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        Page<ProductCategory> page = new Page<>(currentPage, 10);
        List<ProductCategory> productCategoryList = productCategoryMapper.getPagerAllAddParentName(new QueryWrapper<>(), page);
        Pager pager = new Pager(page.getPages(), 10, currentPage, "product-category/list?");
        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("pager", pager);
        return "/backend/productCategory/productCategoryList";
    }

    /**
     * 获取分类下的子类
     *
     * @param parentId 父类id，id为0代表这是顶级分类
     */
    @ResponseBody
    @GetMapping("child")
    public ReturnResult getChild(Integer parentId) {
        List<ProductCategory> categories = productCategoryMapper.selectList(new QueryWrapper<ProductCategory>()
                .eq("parentId", parentId)
        );
        return new ReturnResult(categories);
    }

    /**
     * 修改分类的页面
     *
     * @param id    分类id {@link ProductCategory#getId()}
     * @param model
     * @return
     */
    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        ProductCategory productCategory = productCategoryMapper.selectById(id);
        model.addAttribute("productCategory", productCategory);
        List<ProductCategory> productCategoryList1 = productCategoryMapper
                .selectList(new QueryWrapper<ProductCategory>()
                        .eq("type", "1")
                );
        List<ProductCategory> productCategoryList2 = productCategoryMapper
                .selectList(new QueryWrapper<ProductCategory>()
                        .eq("type", "2")
                );
        ProductCategory parentProductCategory = productCategoryMapper.selectById(productCategory.getParentId());
        model.addAttribute("productCategoryList1", productCategoryList1);
        model.addAttribute("productCategoryList2", productCategoryList2);
        model.addAttribute("parentProductCategory", parentProductCategory);
        return "/backend/productCategory/toAddProductCategory";
    }

    /**
     * 添加分类的页面
     *
     * @param model
     * @return
     */
    @GetMapping("add")
    public String add(Model model) {
        List<ProductCategory> productCategoryList1 = productCategoryMapper
                .selectList(new QueryWrapper<ProductCategory>()
                        .eq("type", "1")
                );
        List<ProductCategory> productCategoryList2 = productCategoryMapper
                .selectList(new QueryWrapper<ProductCategory>()
                        .eq("type", "2")
                );
        model.addAttribute("productCategoryList1", productCategoryList1);
        model.addAttribute("productCategoryList2", productCategoryList2);
        return "/backend/productCategory/toAddProductCategory";
    }

    /**
     * 提交添加分类的请求
     *
     * @param name                  类别名称
     * @param type                  分类级别 {@link ProductCategory#getType()}
     * @param productCategoryLevel1 父类一级id
     * @param productCategoryLevel2 父类二级id
     * @return 返回json数据 {@link ReturnResult}
     */
    @ResponseBody
    @PostMapping("add")
    public ReturnResult add(
            String name, Integer type,
            Integer productCategoryLevel1, Integer productCategoryLevel2
    ) {
        if (type == null) {
            return ReturnResult.err("请选择分类级别");
        }
        ProductCategory category = new ProductCategory();
        category.setName(name);
        category.setType(type);
        category.setParentId(productCategoryLevel2 == 0 ? productCategoryLevel1 : productCategoryLevel2);
        category.setIconClass("");
        productCategoryMapper.insert(category);
        return new ReturnResult().returnSuccess();
    }

    /**
     * 提交修改分类的请求
     *
     * @param id                    分类id，用于按id修改分类
     * @param name                  新的分类名称
     * @param type                  分类级别，用于检查是否有子类
     * @param productCategoryLevel1 父类一级id
     * @param productCategoryLevel2 父类二级id
     * @return 返回json数据 {@link ReturnResult}
     */
    @ResponseBody
    @PostMapping("update")
    public ReturnResult update(
            Integer id, String name, Integer type,
            Integer productCategoryLevel1, Integer productCategoryLevel2
    ) {
        if (type == 2 && productCategoryLevel1 == 0) {
            return ReturnResult.err("请选择一级分类");
        }
        if (type == 3 && productCategoryLevel2 == 0) {
            return ReturnResult.err("请选择二级分类");
        }
        ProductCategory category = new ProductCategory();
        category.setId(id);
        category.setName(name);
        category.setParentId(productCategoryLevel2 == 0 ? productCategoryLevel1 : productCategoryLevel2);
        category.setType(type);
        productCategoryMapper.updateById(category);
        return new ReturnResult().returnSuccess();
    }

    /**
     * 提交删除分类的请求
     *
     * @param id   分类id，用于按id删除 & 判断这个分类是否有商品
     * @param type 分类级别，用于判断是否有子分类
     * @return {@link ReturnResult} 如果这个分类下有子分类或有商品，都不能删除
     */
    @ResponseBody
    @GetMapping("delete")
    public ReturnResult delete(Integer id, Integer type) {
        Integer childSize = productCategoryMapper.selectCount(new QueryWrapper<ProductCategory>()
                .eq("parentId", id));
        if (childSize > 0) {
            return ReturnResult.err("此分类下有子分类，不能删除");
        }
        Integer productSize = productMapper.selectCount(new QueryWrapper<Product>()
                .eq("categoryLevel" + type + "Id", id));
        if (productSize > 0) {
            return ReturnResult.err("此分类下有商品，不能删除");
        }
        productCategoryMapper.deleteById(id);
        return new ReturnResult().returnSuccess();
    }
}

