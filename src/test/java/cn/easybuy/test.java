package cn.easybuy;

import cn.easybuy.mapper.ProductCategoryMapper;
import cn.easybuy.pojo.vo.ProductCategoryVo;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.util.List;

@SpringBootTest
public class test {
    @Resource
    ProductCategoryService service;

    @Test
    public void testQuery() {
        List<ProductCategoryVo> list = service.queryAllProductCategoryList();
        for (ProductCategoryVo vo : list) {
            System.out.println(vo);
        }
    }
}
