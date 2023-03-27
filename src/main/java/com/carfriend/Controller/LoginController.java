package com.carfriend.Controller;

import com.carfriend.Domain.Token;
import com.carfriend.Domain.User;
import com.carfriend.Service.IUserService;
import com.carfriend.Util.Code;
import com.carfriend.Util.Result;
import com.carfriend.Util.TokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/***
 * 处理用户登录事务
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    /***
     * 用户账号密码登录
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return 登录是否成功，token携带返回
     */
    @PostMapping("/defaultLogin")
    public Result UserDefaultLogin(@RequestParam(name = "account") String userAccount,
                                   @RequestParam(name = "password") String userPassword){
        User user = userService.DefaultLogin(userAccount, userPassword);
        if(user==null){
            return new Result(Code.ERROR,"用户不存在");
        }
        //TODO 后期添加自动生成token的功能
        Token token = TokenCreator.SetNewToken(user);
        Map<String,Object> result=new HashMap<>();
        result.put("user",user);
        result.put("token",token);
        return new Result(Code.SUCCESS,result,"登录成功");
    }


    /***
     * 用户注册
     * @param params 注册参数
     * @deprecated account 账号 password 密码 name用户名 description 用户简介
     * @return 注册是否成功
     */
    @PostMapping("/register")
    public Result UserRegister(@RequestParam Map<String,String> params){
        User user=new User();
        user.setUserAccount(params.get("account"));
        user.setUserPassword(params.get("password"));
        user.setUserName(params.get("name"));
        user.setUserDescription(params.get("description"));
        user.setPermission(0);
        if(!userService.userRegister(user)){
            return new Result(Code.ERROR,"发生了未知的错误");
        }
        return new Result(Code.SUCCESS,"注册成功");
    }


    /***
     * 用户是否已注册
     * @param userAccount 用户账号即手机号码
     * @return 是否已注册，data中为true即已注册，反之未注册
     */
    @PostMapping("/isExist")
    public Result UserIsExist(@RequestParam(name ="account") String userAccount){
        if(userService.userIsExist(userAccount)){
            return new Result(Code.SUCCESS,true,"用户已注册");
        }
        return new Result(Code.SUCCESS,false,"用户未注册");
    }
}
