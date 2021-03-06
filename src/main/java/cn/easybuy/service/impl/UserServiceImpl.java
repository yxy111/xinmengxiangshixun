package cn.easybuy.service.impl;

import cn.easybuy.pojo.User;
import cn.easybuy.mapper.UserMapper;
import cn.easybuy.service.UserService;
import cn.easybuy.utils.ReturnResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户模块管理
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //添加用户
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(User user) {
        int i = baseMapper.insert(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    //根据id跟新用户
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(User user) {
        int i = baseMapper.updateById(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    //根据id删除用户
    @Override
    public boolean deleteUserById(Integer userId) {
        int i = baseMapper.deleteById(userId);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    //根据id查询单个用户信息
    @Override
    public User getUser(Integer userId, String loginName) {
        User user = baseMapper.selectById(userId);
        return user;
    }

    //分页查询用户信息
    @Override
    public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
        if (currentPageNo == null) {
            currentPageNo=1;
        }
        Page<User> page = new Page<>(currentPageNo, pageSize);
        baseMapper.selectPage(page, null);
        List<User> userList = page.getRecords();
        return userList;
    }

    @Override
    public int count() {
        Integer count = baseMapper.selectCount(null);
        return count;
    }

    @Override
    public User login(String loginName, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("loginName", loginName)
                .eq("password", password);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public ReturnResult register(User user) {
        User one = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("loginName", user.getLoginName())
        );
        if (one == null) {
            baseMapper.insert(user);
            return new ReturnResult().returnSuccess();
        }
        return ReturnResult.err("已有同名的用户");
    }
}
