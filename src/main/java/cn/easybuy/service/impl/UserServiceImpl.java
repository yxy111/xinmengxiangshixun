package cn.easybuy.service.impl;

import cn.easybuy.pojo.User;
import cn.easybuy.mapper.UserMapper;
import cn.easybuy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


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

    @Override
    public boolean deleteUserById(Integer userId) {
        int i = baseMapper.deleteById(userId);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUser(Integer userId, String loginName) {
        User user = baseMapper.selectById(userId);
        return user;
    }

    @Override
    public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
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
}
