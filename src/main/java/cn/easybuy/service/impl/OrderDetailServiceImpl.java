package cn.easybuy.service.impl;

import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.pojo.OrderDetail;
import cn.easybuy.mapper.OrderDetailMapper;
import cn.easybuy.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单详细
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Override
    public void add(OrderDetail detail) {

    }

    @Override
    public void deleteById(OrderDetail detail) {

    }

    @Override
    public OrderDetail getOrderDetailById(Integer id) {
        return null;
    }

    @Override
    public List<OrderDetail> getOrderDetailList(Integer orderId) {
        return null;
    }

    @Override
    public Integer queryOrderDetailCount(Integer currentPageNo, Integer pageSize) {
        return null;
    }

    @Override
    public ShoppingCart modifyShoppingCart(String productId, String quantityStr, ShoppingCart cart) {
        return null;
    }

    @Override
    public ShoppingCart calculate(ShoppingCart cart)  {
        return null;
    }
}
