package com.carfriend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carfriend.Domain.User;
import com.carfriend.Mapper.IUserMapper;
import com.carfriend.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<IUserMapper,User> implements IUserService{
    @Autowired
    private IUserMapper userMapper;

    /***
     * 用户普通登录
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return 指定用户
     */
    @Override
    public User DefaultLogin(String userAccount, String userPassword) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount).eq("userPassword",userPassword);
        return userMapper.selectOne(queryWrapper);
    }

    /***
     * 用户注册
     * @param user 用户个人信息
     * @return 注册是否成功
     */
    @Override
    public Boolean userRegister(User user) {
        return userMapper.insert(user)==1?true:false;
    }

    /***
     * 用户是否已经注册过了
     * @param userAccount 用户账号即电话号码
     * @return true 即已被注册   false 即未被注册
     */
    @Override
    public Boolean userIsExist(String userAccount) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        return userMapper.selectOne(queryWrapper)!=null?true:false;
    }
}
