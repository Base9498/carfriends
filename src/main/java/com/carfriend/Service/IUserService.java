package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.User;

public interface IUserService extends IService<User> {


    User DefaultLogin(String userAccount, String userPassword);

    Boolean userRegister(User user);

    Boolean userIsExist(String userAccount);

    User GetUserInfos(String userID);
}
