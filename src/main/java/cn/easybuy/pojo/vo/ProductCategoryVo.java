package cn.easybuy.pojo.vo;

import cn.easybuy.pojo.Product;
import cn.easybuy.pojo.ProductCategory;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@ApiModel(value = "ProductCategoryVo对象", description = "")
public class ProductCategoryVo {
    @ApiModelProperty(value = "分类实体类")
    private ProductCategory productCategory;

    @ApiModelProperty(value = "这个分类下所以的商品")
    private List<Product> productList;

    @ApiModelProperty(value = "此分类下所有的子类")
    private List<ProductCategoryVo> productCategoryVoList;
}
