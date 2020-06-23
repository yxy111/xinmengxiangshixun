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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("easybuy_product_category")
@ApiModel(value = "ProductCategory对象", description = "")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "父级目录id")
    @TableField("parentId")
    private Integer parentId;

    @ApiModelProperty(value = "级别(1:一级 2：二级 3：三级)")
    private Integer type;

    @ApiModelProperty(value = "图标")
    @TableField("iconClass")
    private String iconClass;

    /**
     * 修改：李凤强
     */
    @ApiModelProperty(value = "父级类型名称")
    @TableField(exist = false)
    private String parentName;
}
