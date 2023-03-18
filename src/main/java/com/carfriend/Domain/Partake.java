package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Partake")
public class Partake {
    /**
     *  用户的ID
     */
    private User userID;
    /**
     *  活动的ID，要知道活动详情
     */
    private Activity activityID;
    /**
     *  参与时间
     */
    private Date partakeTime;
}
