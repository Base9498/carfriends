package com.carfriend;

import com.carfriend.Domain.Activity;
import com.carfriend.Service.IActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ActivityTest {

    @Autowired
    private IActivityService activityService;

    @Test
    void TestGetAllActivity(){
        System.out.println(activityService.GetAllActivity());
    }

    @Test
    void TestGetAllAfootActivity(){
        System.out.println(activityService.GetAllAfootActivity());
    }

    @Test
    void TestGetAllEndedActivity(){
        System.out.println(activityService.GetAllEndedActivity());
    }

    @Test
    void TestGetActivityInfosByUser(){
        System.out.println(activityService.GetActivityInfosByUser("10000002"));
    }

    @Test
    void TestGetActivityInfo(){
        System.out.println(activityService.GetActivityInfo("69400002"));
    }

    @Test
    void TestInitiateActivity(){
        Activity activity=new Activity();
        activity.setActivityName("我的第二情人");
        activity.setActivityAddress("线上");
        activity.setActivityTime(new Date());
        activity.setActivityNumber(100L);
        activity.setActivityDescribe("展示一下陪你最久的那台车吧");
        activity.setUserID(10000001L);
        activity.setActivityState("活动中");
        System.out.println(activityService.InitiateActivity(activity));
    }

    @Test
    void TestEndActivity(){
        Activity activity=new Activity();
        activity.setId(69400004L);
        activity.setActivityNumber(1000);
        activity.setUserID(10000001L);
        activity.setActivityState("已结束");
        System.out.println(activityService.EndActivity(activity));
    }


}
