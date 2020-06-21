package cn.easybuy.mapper;

import cn.easybuy.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {



}
