package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("User")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    @TableField(value = "userAccount")
    private String userAccount;
    @TableField(value = "userPassword",select = false)
    private String userPassword;
    @TableField(value = "userName")
    private String userName;
    @TableField(value = "userDescription")
    private String userDescription;
    @TableField(value = "userAvatar")
    private String userAvatar;
    @TableField(value = "permission")
    private int permission;
    @TableField(exist = false)
    private String token;
}
