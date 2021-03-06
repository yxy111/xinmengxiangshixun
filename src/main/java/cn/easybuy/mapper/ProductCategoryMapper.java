package cn.easybuy.mapper;

import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.pojo.vo.OrderVo;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 *
 * <b>
 * 最后修改：李凤强
 * 修改时间：2020-06-22
 * </b>
 */
@Repository
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    /**
     * 查询这个类型所有的分类
     * 作者：李凤强
     *
     * @param type 分类级别
     * @return
     */
    @Select("select * from easybuy_product_category where type=#{type}")
    @Results(id = "ProductCategoryVo", value = {
            @Result(property = "productCategory.id", column = "id"),
            @Result(property = "productCategory.name", column = "name"),
            @Result(property = "productCategory.parentId", column = "parentId"),
            @Result(property = "productCategory.type", column = "type"),
            @Result(property = "productCategory.iconClass", column = "iconClass"),
    })
    List<ProductCategoryVo> selectProductCategoryVoByType(int type);

    /**
     * 查询这个这个分类下所有子类，并根据级别查询
     * 作者：李凤强
     *
     * @param parentId 分类的父类
     * @param type     分类的级别
     * @return
     */
    @Select("select * from easybuy_product_category where parentId=#{parentId} and type=#{type}")
    @ResultMap("ProductCategoryVo")
    List<ProductCategoryVo> selectProductCategoryVoByParentIdAndType(int parentId, int type);

    /**
     * 查询这个分类的名字
     * 作者：李凤强
     * <b>注意：这个方法在 {@link ProductCategoryMapper#getPagerAllAddParentName(QueryWrapper, Page)}
     * 的 {@link Result}注解中的 {@link Result#one()}变量中有引用
     * 不要删除
     * </b>
     *
     * @param id 分类id
     * @return
     */
    @Select("select name from easybuy_product_category where id=#{id}")
    String selectNameById(int id);

    /**
     * 分页查询所有分类，并且附带{@link ProductCategory#getParentName()}属性
     * 作者：李凤强
     *
     * @param queryWrapper 查询条件
     * @param page         分页条件
     * @return
     */
    @Select("select * from easybuy_product_category")
    @Results({
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "parentName",
                    column = "parentId",
                    one = @One(select = "cn.easybuy.mapper.ProductCategoryMapper.selectNameById")
            )
    })
    List<ProductCategory> getPagerAllAddParentName(
            @Param(Constants.WRAPPER) QueryWrapper<ProductCategory> queryWrapper,
            Page<ProductCategory> page
    );
}
