package cn.easybuy.service.impl;

import cn.easybuy.params.NewsParams;
import cn.easybuy.pojo.News;
import cn.easybuy.mapper.NewsMapper;
import cn.easybuy.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  新闻服务
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {


    @Override
    public void update(News news) {

    }

    @Override
    public void addNews(News news) {

    }

    @Override
    public News findNewsById(Integer id) {
        return null;
    }

    @Override
    public void deleteNews(Integer id) {

    }

    @Override
    public List<News> queryNewsList(Integer currentPageNo,
                                    Integer pageSize) {
        return null;
    }

    @Override
    public Integer queryNewsCount(Integer currentPageNo,
                                  Integer pageSize) {
        return null;
    }
}
