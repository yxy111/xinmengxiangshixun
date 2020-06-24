package cn.easybuy.mapper;

import cn.easybuy.pojo.Order;
import cn.easybuy.pojo.vo.OrderVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口  订单接口
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {


    // 个人订单分页查询根据用户id  或全部
    List<OrderVo> getOneOrder1(@Param(Constants.WRAPPER) QueryWrapper<OrderVo> queryWrapper, Page<OrderVo> page);
}
