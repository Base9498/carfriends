package com.carfriend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carfriend.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
public interface IUserMapper extends BaseMapper<User> {

    /***
     * 用户普通登录
     * @param userAccount 用户账号
     * @param passWord 用户密码
     * @return 指定用户
     */
    User DefaultLogin(String userAccount,String userPassWord);

    /***
     * 用户注册
     * @param user 用户个人信息
     * @return 注册是否成功
     */
    Boolean userRegister(User user);

    /***
     * 用户是否已经注册过了
     * @param userAccount 用户账号即电话号码
     * @return 是否已经注册过了
     */
    Boolean userIsExist(String userAccount);

}
