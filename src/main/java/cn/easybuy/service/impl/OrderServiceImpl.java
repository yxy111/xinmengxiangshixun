package cn.easybuy.service.impl;

import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.pojo.Order;
import cn.easybuy.mapper.OrderMapper;
import cn.easybuy.pojo.OrderDetail;
import cn.easybuy.pojo.User;
import cn.easybuy.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  订单处理
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public Order payShoppingCart(ShoppingCart cart, User user, String address) {
        return null;
    }

    @Override
    public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int count(Integer userId) {
        return 0;
    }

    @Override
    public List<OrderDetail> getOrderDetailList(Integer orderId) {
        return null;
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Order getOrderById(Integer id) {
        return null;
    }
}
