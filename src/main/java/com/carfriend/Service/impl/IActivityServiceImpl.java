package com.carfriend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carfriend.Domain.Activity;
import com.carfriend.Mapper.IActivityMapper;
import com.carfriend.Service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IActivityServiceImpl extends ServiceImpl<IActivityMapper, Activity> implements IActivityService {

    @Autowired
    private IActivityMapper activityMapper;

    /***
     * 获取所有活动 无论状态
     * @return 活动列表
     */
    @Override
    public List<Activity> GetAllActivity() {
        //TODO 应该只显示发起者的名字
        return activityMapper.selectList(null);
    }

    /***
     * 获取正在进行中的所有活动
     * @return 正在进行中的活动列表
     */
    @Override
    public List<Activity> GetAllAfootActivity() {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("activityState","活动中");
        return activityMapper.selectList(queryWrapper);
    }

    /***
     * 获取已结束的所有活动
     * @return 已结束的活动列表
     */
    @Override
    public List<Activity> GetAllEndedActivity() {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("activityState","已结束");
        return activityMapper.selectList(queryWrapper);
    }

    /***
     * 返回用户发起的所有活动
     * @param userID 发起者ID
     * @return 返回用户发起的活动列表
     */
    @Override
    public List<Activity> GetActivityInfosByUser(String userID) {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userID",userID);
        return activityMapper.selectList(queryWrapper);
    }

    /***
     * 获取活动详情
     * @param activityID 活动ID
     * @return 活动详情
     */
    @Override
    public Activity GetActivityInfo(String activityID) {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",activityID);
        return activityMapper.selectOne(queryWrapper);
    }

    /***
     * 发起活动
     * @param activity 活动内容
     * @return 发起是否成功
     */
    @Override
    public Boolean InitiateActivity(Activity activity) {
        return activityMapper.insert(activity)==1?true:false;
    }

    /***
     * 结束某个活动，只有发起人才可以结束
     * @param activity 活动详情
     * @return 结束成功与否
     */
    @Override
    public Boolean EndActivity(Activity activity) {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",activity.getId());
        return activityMapper.update(activity,queryWrapper)==1?true:false;
    }


}
