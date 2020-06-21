package cn.easybuy.service;

import cn.easybuy.params.NewsParams;
import cn.easybuy.pojo.News;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
public interface NewsService extends IService<News> {


    /**
     * 修改新闻
     * @param news
     * @throws Exception
     */
    public void update(News news);
    /**
     * 保存新闻
     * @param news
     */
    void addNews(News news);//保存新闻
    /**
     * 根据id查询新闻
     * @return
     */
    News findNewsById(Integer id);
    /***
     * 删除新闻
     */
    void deleteNews(Integer id);
    /***
     * 查询新闻列表
     * @param
     * @return
     */
    List<News> queryNewsList(Integer currentPageNo,
                             Integer pageSize);
    /***
     * 查询数目
     * @param
     * @return
     */
    Integer queryNewsCount(Integer currentPageNo,
                           Integer pageSize);

}
