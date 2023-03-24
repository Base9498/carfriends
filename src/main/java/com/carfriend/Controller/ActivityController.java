package com.carfriend.Controller;

import com.carfriend.Domain.Activity;
import com.carfriend.Domain.Partake;
import com.carfriend.Service.IActivityService;
import com.carfriend.Service.IPartakeService;
import com.carfriend.Util.Code;
import com.carfriend.Util.FormattingTool;
import com.carfriend.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private IActivityService activityService;
    @Autowired
    private IPartakeService partakeService;

    /***
     * 获取所有活动
     * @return 所有活动列表
     */
    @GetMapping("/allActivity")
    public Result GetAllActivity(){
        List<Activity> activities = activityService.GetAllActivity();
        if(!activities.isEmpty())
            return new Result(Code.SUCCESS,activities,"获取成功");
        return new Result(Code.ERROR,"获取失败");
    }

    /***
     * 获取正在进行中的活动
     * @return 活动列表
     */
    @GetMapping("/AfootActivity")
    public Result GetAllAfootActivity(){
        List<Activity> activities = activityService.GetAllAfootActivity();
        if(!activities.isEmpty())
            return new Result(Code.SUCCESS,activities,"获取成功");
        return new Result(Code.ERROR,"获取失败");
    }

    /***
     * 获取所有已经结束的活动
     * @return 活动列表
     */
    @GetMapping("/EndedActivity")
    public Result GetAllEndedActivity(){
        List<Activity> activities = activityService.GetAllEndedActivity();
        if(!activities.isEmpty())
            return new Result(Code.SUCCESS,activities,"获取成功");
        return new Result(Code.ERROR,"获取失败");
    }

    /***
     * 获取活动详情
     * @param activityID 活动id
     * @return 指定活动
     */
    @GetMapping("/activityInfo/{activityID}")
    public Result GetActivityInfo(@PathVariable("activityID") String activityID){
        Activity activity = activityService.GetActivityInfo(activityID);
        if(activity!=null){
            return new Result(Code.SUCCESS,activity,"获取成功");
        }
        return new Result(Code.ERROR,"获取失败");
    }

    /***
     * 发起活动
     * @param params 活动参数
     * @return 发起结果
     */
    @PostMapping("/initActivity")
    public Result InitialActivity(@RequestParam Map<String,String> params){
        Activity activity=new Activity();
        activity.setActivityName(params.get("name"));
        activity.setActivityAddress(params.get("address"));
        activity.setActivityTime(FormattingTool.StringFormatDate(params.get("time")));
        activity.setActivityNumber(Long.valueOf(params.get("number")));
        activity.setActivityDescribe(params.get("description"));
        activity.setUserID(Long.valueOf(params.get("user")));
        activity.setActivityState("活动中");
        Boolean success = activityService.InitiateActivity(activity);
        if(success)
            return new Result(Code.SUCCESS,success,"发起成功");
        return new Result(Code.ERROR,success,"发生错误");
    }

    /***
     * 结束活动
     * @param activityID 活动id
     * @return 结束结果
     */
    @PostMapping("/endedActivity")
    public Result EndedActivity(@RequestParam(name="activityID") String activityID){
        Activity activity=new Activity();
        activity.setId(FormattingTool.StringFormatLong(activityID));
        activity.setActivityState("已结束");
        Boolean success = activityService.EndActivity(activity);
        if(success)
            return new Result(Code.SUCCESS,success,"已结束活动");
        return new Result(Code.ERROR,"结束失败");
    }

    /***
     * 参加活动
     * @param params 参加活动相关参数
     * @return 参加结果
     */
    @PostMapping("/partake")
    public Result PartakeActivity(@RequestParam Map<String,String> params){
        Partake partake=new Partake();
        partake.setUserID(FormattingTool.StringFormatLong(params.get("user")));
        partake.setActivityID(FormattingTool.StringFormatLong(params.get("activity")));
        partake.setPartakeTime(FormattingTool.StringFormatDate(params.get("time")));
        Boolean success = partakeService.JoinPartake(partake);
        if(success)
            return new Result(Code.SUCCESS,success,"参加成功");
        return new Result(Code.ERROR,success,"发生错误");
    }

    /***
     * 获取用户参加的所有活动
     * @param userID 用户id
     * @return 活动列表
     */
    @GetMapping("/getPartake/{userID}")
    public Result GetPartakeByUer(@PathVariable("userID") String userID){
        List<Partake> partakes = partakeService.FindAllPartake(userID);
        if(!partakes.isEmpty())
            return new Result(Code.SUCCESS,partakes,"获取成功");
        return new Result(Code.ERROR,"无相关信息");
    }
}
