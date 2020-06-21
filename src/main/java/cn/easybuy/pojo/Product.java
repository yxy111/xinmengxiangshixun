package cn.easybuy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("easybuy_product")
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "价格")
    private Float price;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "分类1")
    @TableField("categoryLevel1Id")
    private Integer categoryLevel1Id;

    @ApiModelProperty(value = "分类2")
    @TableField("categoryLevel2Id")
    private Integer categoryLevel2Id;

    @ApiModelProperty(value = "分类3")
    @TableField("categoryLevel3Id")
    private Integer categoryLevel3Id;

    @ApiModelProperty(value = "文件名称")
    @TableField("fileName")
    private String fileName;

    @ApiModelProperty(value = "是否删除(1：删除 0：未删除)")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
