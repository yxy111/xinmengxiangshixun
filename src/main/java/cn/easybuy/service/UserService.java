package cn.easybuy.service;

import cn.easybuy.pojo.User;
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
public interface UserService extends IService<User> {
    public boolean add(User user);

    public boolean update(User user);

    public boolean deleteUserById(Integer userId);

    public User getUser(Integer userId,String loginName);

    public List<User> getUserList(Integer currentPageNo, Integer pageSize);

    public int count();
}