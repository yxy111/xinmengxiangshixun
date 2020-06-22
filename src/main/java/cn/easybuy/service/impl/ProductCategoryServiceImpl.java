package cn.easybuy.service.impl;

import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.params.ProductCategoryParam;
import cn.easybuy.pojo.Product;
import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.mapper.ProductCategoryMapper;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Resource
    ProductCategoryMapper productCategoryMapper;

    @Resource
    ProductMapper productMapper;

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
        List<ProductCategoryVo> productCategoryVos = productCategoryMapper
                .selectProductCategoryVoByType(1);
        for (ProductCategoryVo categoryVo : productCategoryVos) {
            List<ProductCategoryVo> list = productCategoryMapper
                    .selectProductCategoryVoByParentIdAndType(
                            categoryVo.getProductCategory().getId(), 2
                    );
            List<Product> products = productMapper
                    .selectByCategoryLevel1Id(
                            categoryVo.getProductCategory().getId()
                    );
            categoryVo.setProductList(products);
            categoryVo.setProductCategoryVoList(list);
            for (ProductCategoryVo vo : list) {
                List<ProductCategoryVo> list2 = productCategoryMapper
                        .selectProductCategoryVoByParentIdAndType(
                                vo.getProductCategory().getId(), 3
                        );
                List<Product> products2 = productMapper
                        .selectByCategoryLevel1Id(
                                categoryVo.getProductCategory().getId()
                        );
                vo.setProductList(products2);
                vo.setProductCategoryVoList(list2);
            }
        }
        return productCategoryVos;
    }
}
