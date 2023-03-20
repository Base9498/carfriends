package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.Partake;

import java.util.List;

public interface IPartakeService extends IService<Partake> {

    Boolean JoinPartake(String userID,String activityID);

    List<Partake> FindAllPartake(String userID);
}
