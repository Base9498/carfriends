package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Permission")
public class Permission {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    @TableField("permission")
    private int permission;
    @TableField("permissionDetail")
    private String detail;
}
