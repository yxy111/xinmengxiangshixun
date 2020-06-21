package cn.easybuy.service;

import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.pojo.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
public interface OrderDetailService extends IService<OrderDetail> {

    public void add(OrderDetail detail);

    public void deleteById(OrderDetail detail) ;

    public OrderDetail getOrderDetailById(Integer id);

    public List<OrderDetail> getOrderDetailList(Integer orderId);

    public Integer queryOrderDetailCount(Integer currentPageNo,
                                         Integer pageSize);


    public ShoppingCart modifyShoppingCart(String productId, String quantityStr, ShoppingCart cart) ;

    public ShoppingCart calculate(ShoppingCart cart);
}
