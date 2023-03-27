package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bind {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private long id;
    @TableField("userID")
    private long userID;
    @TableField("carCall")
    private String carCall;
    @TableField("carName")
    private String carName;
    @TableField("carAvatar")
    private String carAvatar;
}
