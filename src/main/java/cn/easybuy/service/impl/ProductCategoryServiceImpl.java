package cn.easybuy.service.impl;

import cn.easybuy.params.ProductCategoryParam;
import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.mapper.ProductCategoryMapper;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  商品分类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Override
    public ProductCategory getById(Integer id) {
        return null;
    }

    @Override
    public List<ProductCategory> queryProductCategoryList(Integer currentPageNo,
                                                          Integer pageSize) {
        return null;
    }

    @Override
    public int queryProductCategoryCount(Integer currentPageNo,
                                         Integer pageSize) {
        return 0;
    }

    @Override
    public void modifyProductCategory(ProductCategory productCategory) {

    }

    @Override
    public void addProductCategory(ProductCategory productCategory) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<ProductCategoryVo> queryAllProductCategoryList() {
        return null;
    }
}
