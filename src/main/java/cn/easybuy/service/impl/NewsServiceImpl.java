package cn.easybuy.service.impl;

import cn.easybuy.params.NewsParams;
import cn.easybuy.pojo.News;
import cn.easybuy.mapper.NewsMapper;
import cn.easybuy.pojo.vo.Pager;
import cn.easybuy.service.NewsService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  新闻管理模块服务
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

    //  新闻分页查询
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, Object> queryNewsList(Integer currentPageNo,
                                             Integer pageSize) {

        if (currentPageNo == null) {
            currentPageNo=1;
        }
        Page<News> page = new Page<>(currentPageNo, 10);
        baseMapper.selectPage(page, null);
        List<News> newsList = page.getRecords();
        long total = page.getPages();
        Pager pager = new Pager(total, 10, currentPageNo,"admin/news/allnew?");
        Map<String, Object> map = new HashMap<>();
        map.put("newsList", newsList);
        map.put("pager", pager);
        return map;
    }

    @Override
    public Integer queryNewsCount(Integer currentPageNo,
                                  Integer pageSize) {
        return null;
    }
}
