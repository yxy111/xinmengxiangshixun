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

    @Deprecated
    public boolean add(Product product);

    @Deprecated
    public boolean update(Product product);

    @Deprecated
    public boolean deleteProductById(Integer productId);

    /**
     * 根据商品id查询商品
     * 作者：李凤强
     *
     * @param productId 商品id
     * @return
     */
    public Product getProductById(Integer productId);

    @Deprecated
    public List<Product> getProductList(Integer currentPageNo, Integer pageSize,
                                        String proName, Integer categoryId, Integer level);

    @Deprecated
    public int count(String proName, Integer categoryId, Integer level);

    @Deprecated
    public boolean updateStock(Integer productId, Integer stock);

    /**
     * 根据商品类别id和类别等级查询所有商品
     * 作者：李凤强
     *
     * @param category 商品类别id
     * @param level    类别等级
     * @return
     */
    List<Product> getProductList(Integer category, Integer level);

    /**
     * 更具商品名称模糊查询商品
     * 作者：李凤强
     *
     * @param fuzzyName 查询关键字
     * @return
     */
    List<Product> selectProductByFuzzyName(String fuzzyName);
}
