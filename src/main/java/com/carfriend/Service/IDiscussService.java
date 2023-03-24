package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.Discuss;

import java.util.List;

public interface IDiscussService extends IService<Discuss> {
    List<Discuss> FindDiscussByUser(String userID);

    List<Discuss> GetCarAllDiscuss(String carID);

    Boolean PublishDiscussion(Discuss discuss);
}
