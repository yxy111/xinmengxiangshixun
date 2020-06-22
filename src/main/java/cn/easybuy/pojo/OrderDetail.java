package cn.easybuy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
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
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("easybuy_order_detail")
@ApiModel(value="OrderDetail对象", description="")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
   @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单主键")
    @TableField("orderId")
    private Integer orderId;

    @ApiModelProperty(value = "商品主键")
    @TableField("productId")
    private Integer productId;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "消费")
    private Float cost;

    private  Product product;//商品
}
