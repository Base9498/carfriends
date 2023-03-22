package com.carfriend.Domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bind {
    @TableField("userID")
    private long userID;
    @TableField("carID")
    private long carID;
    @TableField("carAvatar")
    private String carAvatar;
}
