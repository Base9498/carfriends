package com.carfriend;

import com.carfriend.Domain.User;
import com.carfriend.Service.IUserService;
import com.carfriend.Service.impl.IUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void TestUserDefaultLogin(){
        System.out.println(userService.DefaultLogin("12345678901", "123456"));
    }

    @Test
    void TestUserRegister(){
        User user=new User();
        user.setUserAccount("19124332590");
        user.setUserPassword("123456");
        user.setUserName("memoli");
        user.setPermission(0);
        user.setUserDescription("普通用户");
        System.out.println(userService.userRegister(user));
    }

    @Test
    void TestUserIsExist(){
        System.out.println(userService.userIsExist("19124332590"));
    }
}
