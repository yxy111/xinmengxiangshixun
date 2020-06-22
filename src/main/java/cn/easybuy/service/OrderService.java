package cn.easybuy.service;

import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.pojo.Order;
import cn.easybuy.pojo.OrderDetail;
import cn.easybuy.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 *
 *
 *  * OrderService接口方法：
 *  * （1）结算订单（返回类型：Order对象，参数：ShoppingCart对象、User对象、收货地址）。
 *  * （2）根据查询条件，分页显示订单信息列表（返回类型：List<Order>，参数：当前页码、页码容量，用户id）。
 *  * （3）根据条件查询订单表总记录数（返回类型：int，参数：用户id）。
 *  * （4）根据订单id查询订单明细列表（返回类型：List<OrderDetail>，参数：订单id）。
 */
public interface OrderService extends IService<Order> {

    public Order payShoppingCart(ShoppingCart cart, User user, String address);

    public List<Order> getOrderList(Integer userId,
                                    Integer currentPageNo,
                                    Integer pageSize);

    public int count(Integer userId);

    public List<OrderDetail> getOrderDetailList(Integer orderId);

    public void add(Order order) ;

    public void deleteById(Integer id);

    public Order getOrderById(Integer id) ;

    //个人订单分页查询  根据用户id
    Map<String, Object> getOneOrder(Integer id, Integer currentPage);

    //  //全部订单
    Map<String, Object> getAllOrder(Integer currentPage);

    //  订单详情
    Map<String, Object> orderDetails(Integer orderId);
}
