package cn.easybuy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("easybuy_order")
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户主键")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "登录用户名")
    @TableField("loginName")
    private String loginName;

    @ApiModelProperty(value = "用户地址")
    @TableField("userAddress")
    private String userAddress;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "总消费")
    private Float cost;

    @ApiModelProperty(value = "订单号")
    @TableField("serialNumber")
    private String serialNumber;

    private List<OrderDetail>  orderDetailList;//订单明细表


}
