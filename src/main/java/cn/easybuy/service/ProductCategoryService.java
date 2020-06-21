package cn.easybuy.service;

import cn.easybuy.params.ProductCategoryParam;
import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    /**
     * 根据id查询商品分类
     * @param id
     * @return
     */
    public ProductCategory getById(Integer id);
    /**
     * 查询商品分类列表
     *
     * @return
     */
    public List<ProductCategory> queryProductCategoryList(Integer currentPageNo,
                                                          Integer pageSize);
    /**
     * 查询数目
     *
     * @return
     */
    public int queryProductCategoryCount(Integer currentPageNo,
                                         Integer pageSize);
    /**
     * 修改商品分类
     *
     */
    public void modifyProductCategory(ProductCategory productCategory);
    /**
     * 添加商品分类
     *
     */
    public void addProductCategory(ProductCategory productCategory);
    /**
     * 根据id删除
     * @param id
     */
    public void deleteById(Integer id);
    /**
     * 查询全部的商品分类
     * @return
     */
    public List<ProductCategoryVo> queryAllProductCategoryList();
}
