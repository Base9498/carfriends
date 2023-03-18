package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("car")
public class Car {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    @TableField("carName")
    private String carName;
    @TableField("carLevel")
    private String carLevel;
    @TableField("carPrice")
    private String carPrice;
    @TableField("carEngine")
    private String carEngine;
    @TableField("carBox")
    private String carBox;
    @TableField("carPower")
    private String carPower;
    @TableField("carBrand")
    private Brand carBrand;
    @TableField("userID")
    private long userID;
    @TableField("carAvatar")
    private String carAvatar;
    @TableField("carLike")
    private long carLike;
}
