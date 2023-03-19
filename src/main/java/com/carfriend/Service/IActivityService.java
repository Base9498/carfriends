package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.Activity;

import java.util.List;

public interface IActivityService extends IService<Activity> {

    List<Activity> GetAllActivity();

    List<Activity> GetAllAfootActivity();

    List<Activity> GetAllEndedActivity();

    List<Activity> GetActivityInfosByUser(String userID);

    Activity GetActivityInfo(String activityID);

    Boolean InitiateActivity(Activity activity);

    Boolean EndActivity(Activity activity);
}
