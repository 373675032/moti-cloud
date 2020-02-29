package com.moti.service.impl;

import com.moti.entity.User;
import com.moti.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

 /**
 * @ClassName UserServiceImpl
 * @Description (User)表服务实现类
 * @author 莫提
 * @date 2020-02-25 17:19:31
 * @Version 1.0
 **/
 @Service
public class UserServiceImpl extends BaseService implements UserService {

    /**
     * @Description 添加User
     * @author 莫提
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(User user) {
        if(userMapper.insert(user) == 1){
            return true;
        }
        return false;
    }

    /**
     * @Description 删除User
     * @author 莫提
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        if(userMapper.deleteById(userId) == 1){
            return true;
        }
        return false;
    }

    /**
     * @Description 查询单条数据
     * @author 莫提
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return userMapper.queryById(userId);
    }

     /**
      * @Description  通过openID查询单条数据
      * @Author xw
      * @Date 18:29 2020/2/25
      * @Param [userId]
      * @return com.moti.entity.User
      **/
     @Override
     public User getUserByOpenId(String openId) {
         return userMapper.getUserByOpenId(openId);
     }

     /**
     * @Description 查询全部数据
     * @author 莫提
     * @date 2020-02-25 17:19:31
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    /**
     * @Description 实体作为筛选条件查询数据
     * @author 莫提
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 对象列表
     */
    @Override
    public List<User> queryAll(User user) {
        return userMapper.queryAll(user);
    }

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author 莫提
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(User user) {
        if(userMapper.update(user) == 1){
            return true;
        }
        return false;
    }

}