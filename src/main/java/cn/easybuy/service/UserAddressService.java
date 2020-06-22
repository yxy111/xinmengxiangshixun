package cn.easybuy.service;

import cn.easybuy.pojo.UserAddress;
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
public interface UserAddressService extends IService<UserAddress> {
    /**
     * 根据loginName 查询用户地址
     * @param userId
     * @return
     * @throws Exception
     */
    public List<UserAddress> queryUserAdressList(Integer userId) ;
    /**
     * 给用户添加地址
     * @param id
     * @param address
     * @return
     */
    public Integer addUserAddress(Integer id, String address, String remark) ;
    /**
     * 根据id查询地址
     * @param id
     * @return
     */
    public UserAddress getUserAddressById(Integer id);
}
