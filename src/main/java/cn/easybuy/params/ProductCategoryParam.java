package cn.easybuy.params;

import cn.easybuy.pojo.ProductCategory;
import lombok.Data;

@Data
public class ProductCategoryParam extends ProductCategory {
    private Integer starIndex;
    private Integer pageSize;
    private String sort;
    private boolean isPage=false;
}
