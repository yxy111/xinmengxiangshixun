package cn.easybuy.service.impl;

import cn.easybuy.pojo.UserAddress;
import cn.easybuy.mapper.UserAddressMapper;
import cn.easybuy.service.UserAddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    @Override
    public List<UserAddress> queryUserAdressList(Integer userId)  {
        return baseMapper.selectList(new QueryWrapper<UserAddress>()
                .eq("userId", userId)
        );
    }

    @Override
    public Integer addUserAddress(Integer id, String address, String remark)  {
        return null;
    }

    @Override
    public UserAddress getUserAddressById(Integer id) {
        return null;
    }
}
