package cn.easybuy.service.impl;

import cn.easybuy.pojo.Product;
import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品查询
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean deleteProductById(Integer productId) {
        return false;
    }

    @Override
    public Product getProductById(Integer productId) {
        return baseMapper.selectById(productId);
    }

    @Override
    public List<Product> getProductList(Integer currentPageNo, Integer pageSize, String proName, Integer categoryId, Integer level) {
        return null;
    }

    @Override
    public int count(String proName, Integer categoryId, Integer level) {
        return 0;
    }

    @Override
    public boolean updateStock(Integer productId, Integer stock) {
        return false;
    }

    @Override
    public List<Product> getProductList(Integer category, Integer level) {
        switch (level) {
            case 1:
                return baseMapper.selectByCategoryLevel1Id(category);
            case 2:
                return baseMapper.selectByCategoryLevel2Id(category);
            default:
                return baseMapper.selectByCategoryLevel3Id(category);
        }
    }

    @Override
    public List<Product> selectProductByFuzzyName(String fuzzyName) {
        return baseMapper.selectList(new QueryWrapper<Product>()
                .like("name", fuzzyName)
        );
    }
}
