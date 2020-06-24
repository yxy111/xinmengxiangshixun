package cn.easybuy.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单详情列表
 */
@Data
public class commodityVo implements Serializable {

    private Integer quantity;
    private String name;
    private String fileName;
    private Float price;
    private Integer id1;
}
