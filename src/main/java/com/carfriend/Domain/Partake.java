package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Partake")
public class Partake {
    /**
     *  用户的ID
     */
    @TableField("userID")
    private long userID;
    /**
     *  活动的ID，要知道活动详情
     */
    @TableField("activityID")
    private long activityID;
    /**
     *  参与时间
     */
    @TableField("partakeTime")
    private Date partakeTime;
    /***
     * 用户详情
     */
    @TableField(exist = false)
    private User user;
    /***
     * 活动详情
     */
    @TableField(exist = false)
    private Activity activity;
}
