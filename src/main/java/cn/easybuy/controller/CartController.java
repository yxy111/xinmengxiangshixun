package cn.easybuy.controller;

import cn.easybuy.mapper.*;
import cn.easybuy.pojo.Order;
import cn.easybuy.pojo.OrderDetail;
import cn.easybuy.pojo.User;
import cn.easybuy.pojo.UserAddress;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.service.UserAddressService;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.SecurityUtils;
import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.utils.ShoppingCartItem;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author 李凤强
 */
@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    ProductCategoryService productCategoryService;

    @Resource
    ProductMapper productMapper;

    @Resource
    UserAddressService userAddressService;

    @Resource
    UserAddressMapper userAddressMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderDetailMapper orderDetailMapper;

    @GetMapping
    public String cart(Model model) {
        List<ProductCategoryVo> vos = productCategoryService.queryAllProductCategoryList();
        model.addAttribute("productCategoryVoList", vos);
        return "/pre/settlement/toSettlement";
    }

    @GetMapping("settlement1")
    public String settlement1() {
        return "/pre/settlement/settlement1";
    }

    @GetMapping("settlement2")
    public String settlement2(@SessionAttribute("loginUser") User user, Model model) {
        List<UserAddress> addressList = userAddressService.queryUserAdressList(user.getId());
        model.addAttribute("userAddressList", addressList);
        return "/pre/settlement/settlement2";
    }

    /**
     * 提交订单
     */
    @GetMapping("settlement3")
    public String settlement3(
            @SessionAttribute("loginUser") User user,
            @SessionAttribute("cart") ShoppingCart cart,
            @RequestParam("addressId") Integer addressId,
            @RequestParam("newAddress") String newAddress,
            @RequestParam("newRemark") String newRemark,
            Model model
    ) {
        UserAddress userAddress;
        if (addressId == -1) {
            userAddress = UserAddress.builder().address(newAddress).remark(newRemark).build();
        } else {
            userAddress = userAddressMapper.selectById(addressId);
        }
        Order order = Order.builder()
                .userId(user.getId())
                .loginName(user.getLoginName())
                .userAddress(userAddress.getAddress())
                .cost(cart.getTotalCost())
                .serialNumber(SecurityUtils.md5Hex(String.valueOf(System.currentTimeMillis())))
                .build();
        orderMapper.insert(order);
        for (ShoppingCartItem item : cart.items) {
            OrderDetail orderDetail = OrderDetail.builder()
                    .orderId(order.getId())
                    .productId(item.getProduct().getId())
                    .quantity(item.getQuantity())
                    .cost(item.getCost())
                    .build();
            orderDetailMapper.insert(orderDetail);
        }
        cart.items.clear();
        model.addAttribute("currentOrder", order);
        return "/pre/settlement/settlement3";
    }

    /**
     * 添加到购物车
     *
     * @param entityId 商品id product.i
     * @param quantity 商品数量
     */
    @ResponseBody
    @GetMapping("add")
    public ReturnResult add(
            @SessionAttribute(value = "cart", required = false) ShoppingCart cart,
            @RequestParam("entityId") Integer entityId,
            @RequestParam("quantity") Integer quantity
    ) {
        if (cart == null) {
            return ReturnResult.err("用户未登录");
        }
        return cart.addItem(productMapper.selectById(entityId), quantity);
    }

    /**
     * 修改购物车里的商品
     */
    @ResponseBody
    @GetMapping("mod")
    public ReturnResult mod(
            @SessionAttribute(value = "cart", required = false) ShoppingCart cart,
            @RequestParam("entityId") Integer entityId,
            @RequestParam("quantity") Integer quantity
    ) {
        if (cart == null) {
            return ReturnResult.err("用户未登录");
        }
        if (quantity == 0) {
            cart.removeItem(entityId);
        } else {
            cart.modifyQuantity(entityId, quantity);
        }
        return new ReturnResult().returnSuccess();
    }

    /**
     * 刷新购物车，刷新searchBar.jsp页面
     */
    @GetMapping("searchBar")
    public String searchBar() {
        return "/common/pre/searchBar";
    }
}
