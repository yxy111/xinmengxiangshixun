package cn.easybuy.pojo.vo;



import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 订单封装对象
 *
 */
@Data
public class OrderVo implements Serializable {


    private Integer id;
    private String loginName;
    private String userAddress;
    private Float cost;
    private String serialNumber;

    private List<commodityVo> list;

}
