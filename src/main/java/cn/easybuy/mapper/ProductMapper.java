package cn.easybuy.mapper;

import cn.easybuy.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * @param levelId 分类id
     */
    @Select("select * from easybuy_product where categoryLevel1Id=#{levelId};")
    List<Product> selectByCategoryLevel1Id(int levelId);

    /**
     * @param levelId 分类id
     */
    @Select("select * from easybuy_product where categoryLevel2Id=#{levelId};")
    List<Product> selectByCategoryLevel2Id(int levelId);

    /**
     * @param levelId 分类id
     */
    @Select("select * from easybuy_product where categoryLevel3Id=#{levelId};")
    List<Product> selectByCategoryLevel3Id(int levelId);
}
