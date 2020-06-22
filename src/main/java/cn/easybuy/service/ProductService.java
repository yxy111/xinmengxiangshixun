package cn.easybuy.service;

import cn.easybuy.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
public interface ProductService extends IService<Product> {


    public boolean add(Product product);

    public boolean update(Product product);

    public boolean deleteProductById(Integer productId);

    public Product getProductById(Integer productId);

    public List<Product> getProductList(Integer currentPageNo, Integer pageSize,
                                        String proName, Integer categoryId, Integer level);

    public int count(String proName, Integer categoryId, Integer level);

    public boolean updateStock(Integer productId, Integer stock);

    /**
     * 作者：李凤强
     */
    List<Product> getProductList(Integer category, Integer level);

    /**
     * 作者：李凤强
     */
    List<Product> selectProductByFuzzyName(String fuzzyName);
}
