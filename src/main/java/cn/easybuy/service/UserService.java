package cn.easybuy.service;

import cn.easybuy.pojo.User;
import cn.easybuy.utils.ReturnResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
public interface UserService extends IService<User> {
    public boolean add(User user);

    public boolean update(User user);

    public boolean deleteUserById(Integer userId);

    public User getUser(Integer userId, String loginName);

    public List<User> getUserList(Integer currentPageNo, Integer pageSize);

    public int count();

    /**
     * 按登陆条件查询用户
     *
     * @param loginName 用户名
     * @param password  密码
     */
    User login(String loginName, String password);

    /**
     * 用户注册
     *
     * @param user 用户实体类
     */
    ReturnResult register(User user);
}
