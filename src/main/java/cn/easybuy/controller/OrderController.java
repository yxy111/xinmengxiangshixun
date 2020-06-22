package cn.easybuy.controller;


import cn.easybuy.pojo.News;
import cn.easybuy.pojo.Order;
import cn.easybuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //个人订单分页查询  根据用户id
    @GetMapping("personal")
    public String personal(Integer userId, Integer currentPage, Model model) {
      Map<String,Object> map=orderService.getOneOrder(userId,currentPage);

        model.addAttribute("orderList", map.get("orderList"));
        model.addAttribute("pager", map.get("pager"));
        return "/backend/order/orderList";
    }

    //全部订单
    @GetMapping("personalall")
    public String personalall(Integer currentPage, Model model) {
        Map<String,Object> map=orderService.getAllOrder(currentPage);

        model.addAttribute("orderList", map.get("orderList"));
        model.addAttribute("pager", map.get("pager"));
        return "/backend/order/orderList";
    }

    //订单详情
    @GetMapping("orderDetails")
    public  String orderDetails(Integer orderId, Model model)
    {
        Map<String,Object> map= orderService.orderDetails(orderId);
        model.addAttribute("orderList", map.get("orderList"));
        return "/backend/order/orderList";

    }



}

