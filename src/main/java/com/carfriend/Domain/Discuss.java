package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class Discuss {
    @TableId(value="id",type = IdType.AUTO)
    private long id;
    @TableField("userID")
    private long userID;
    @TableField("carID")
    private long carID;
    @TableField("discuss")
    private String discussText;
    @TableField("publishTime")
    private Date publishTime;
    @TableField(exist = false)
    private Car car;
}
