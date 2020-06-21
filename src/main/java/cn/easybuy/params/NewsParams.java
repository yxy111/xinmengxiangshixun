package cn.easybuy.params;

import cn.easybuy.pojo.News;
import lombok.Data;

@Data
public class NewsParams extends News {
    private Integer starIndex;
    private Integer pageSize;
    private String sort;
    private boolean isPage=false;
}
