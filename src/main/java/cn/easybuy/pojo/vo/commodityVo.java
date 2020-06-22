package cn.easybuy.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class commodityVo implements Serializable {

    private Integer quantity;
    private String name;
    private String fileName;
    private Float price;
    private Integer id1;
}
