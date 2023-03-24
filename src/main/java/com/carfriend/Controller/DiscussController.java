package com.carfriend.Controller;

import com.carfriend.Domain.Discuss;
import com.carfriend.Service.IDiscussService;
import com.carfriend.Util.Code;
import com.carfriend.Util.FormattingTool;
import com.carfriend.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/discuss")
public class DiscussController {
    @Autowired
    public IDiscussService discussService;

    /***
     * 查找用户的所有评论
     * @param userID
     * @return 评论列表
     */
    @GetMapping("/userDiscusses/{userID}")
    public Result FindDiscussByUser(@PathVariable("userID") String userID){
        List<Discuss> discussList = discussService.FindDiscussByUser(userID);
        if(!discussList.isEmpty())
            return new Result(Code.SUCCESS,discussList,"获取成功");
        return new Result(Code.ERROR,"获取失败");
    }

    /***
     * 获取车辆帖子下所有的评论
     * @param carID 车辆id
     * @return 评论列表
     */
    @GetMapping("/carDiscuss/{carID}")
    public Result GetCarAllDiscuss(@PathVariable("carID") String carID){
        List<Discuss> discusses = discussService.GetCarAllDiscuss(carID);
        if(!discusses.isEmpty())
            return new Result(Code.SUCCESS,discusses,"获取成功");
        return new Result(Code.ERROR,"获取失败");
    }

    /***
     * 发表评论
     * @param params 评论内容
     * @return 发表结果
     */
    @PostMapping("/publishDiscuss")
    public Result PublishDiscussion(@RequestParam Map<String,String> params){
        Discuss discuss=new Discuss();
        discuss.setUserID(FormattingTool.StringFormatLong(params.get("user")));
        discuss.setCarID(FormattingTool.StringFormatLong(params.get("car")));
        discuss.setDiscussText(params.get("discuss"));
        discuss.setPublishTime(FormattingTool.StringFormatDate(params.get("time")));
        if(discussService.PublishDiscussion(discuss))
            return new Result(Code.SUCCESS,true,"发表成功");
        return new Result(Code.ERROR,false,"发表失败");
    }
}
