package cn.easybuy.service.impl;

import cn.easybuy.pojo.vo.OrderVo;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.pojo.Order;
import cn.easybuy.mapper.OrderMapper;
import cn.easybuy.pojo.OrderDetail;
import cn.easybuy.pojo.User;
import cn.easybuy.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //个人订单分页查询  根据用户id
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, Object> getOneOrder(Integer userId, Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        QueryWrapper<OrderVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userId);
        Page<OrderVo> page = new Page<>(currentPage, 10);
        List<OrderVo> orderList = baseMapper.getOneOrder1(queryWrapper, page);
        Map<String, Object> map = new HashMap<>();
        Pager pager = new Pager(1, 10, currentPage,"admin/order/personal?",userId);
        map.put("orderList", orderList);
        map.put("pager", pager);
        return map;
    }

    //全部订单
    @Override
    public Map<String, Object> getAllOrder(Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        QueryWrapper<OrderVo> queryWrapper = new QueryWrapper<>();
        Page<OrderVo> page = new Page<>(currentPage, 10);
        List<OrderVo> orderList = baseMapper.getOneOrder1(queryWrapper,page);
        Map<String, Object> map = new HashMap<>();
        Pager pager = new Pager(1, 10, currentPage,"admin/order/personalall?");
        map.put("orderList", orderList);
        map.put("pager", pager);
        return map;
    }
}
