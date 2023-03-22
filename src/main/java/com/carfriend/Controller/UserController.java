package com.carfriend.Controller;

import com.carfriend.Domain.Bind;
import com.carfriend.Domain.User;
import com.carfriend.Service.IBindService;
import com.carfriend.Service.IUserService;
import com.carfriend.Util.Code;
import com.carfriend.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/***
 * 处理用户相关事务
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IBindService bindService;

    /***
     * 获取用户详细信息
     * @param userID 用户iD
     * @return 用户详细信息
     */
    @PostMapping("/userInfo")
    public Result GetUserInfo(@RequestParam(name="userid") String userID){
        User user = userService.GetUserInfos(userID);
        if(user==null)
            return new Result(Code.SUCCESS,"用户不存在");
        return new Result(Code.SUCCESS,user,"查找成功");
    }

    /***
     * 用户绑定车辆
     * @param params 绑定参数，即车辆id和用户id
     * @param file 车辆图片，不必要
     * @return 绑定结果
     */
    @PostMapping("/userBind")
    public Result UserBindCar(@RequestParam Map<String,String> params,
                              @RequestParam(name = "file",required = false) MultipartFile file){
        Bind bind=new Bind();
        bind.setUserID(Long.valueOf(params.get("user")));
        bind.setCarID(Long.valueOf(params.get("car")));
        //TODO:添加图片？
        if(!bindService.BindCar(bind))
            return new Result(Code.ERROR,false,"出现错误");
        return new Result(Code.SUCCESS,true,"绑定成功");
    }

    /***
     * 用户是否已经绑定过车辆了
     * @param userID 用户id
     * @return 是否绑定过
     */
    @GetMapping("/userHadBound/{userID}")
    public Result UserHadBound(@PathVariable("userID") String userID){
        Boolean hadBounce = bindService.HadBounce(userID);
        if(hadBounce)
            return new Result(Code.SUCCESS,hadBounce,"已经绑定过车辆了");
        return new Result(Code.SUCCESS,hadBounce,"用户还未有车辆");
    }
}
