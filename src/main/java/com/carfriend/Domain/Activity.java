package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("activity")
public class Activity {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    @TableField("activityName")
    private String activityName;
    @TableField("activityAddress")
    private String activityAddress;
    @TableField("activityTime")
    private Date activityTime;
    @TableField("activityNumber")
    private long activityNumber;
    @TableField("activityDescribe")
    private String activityDescribe;
    @TableField("userID")
    private long userID;
    @TableField("activityState")
    private String activityState;
    @TableField(exist = false)
    private User user;
}
