package com.carfriend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carfriend.Domain.Discuss;
import com.carfriend.Mapper.IDiscussMapper;
import com.carfriend.Service.IDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDiscussServiceImpl extends ServiceImpl<IDiscussMapper, Discuss> implements IDiscussService {

    @Autowired
    private IDiscussMapper discussMapper;

    /***
     * 用户查看自己的所有评论
     * @param userID
     * @return 评论列表
     */
    @Override
    public List<Discuss> FindDiscussByUser(String userID) {
        return discussMapper.FindDiscussByUser(userID);
    }

    /***
     * 获取某个车辆下所有的评论
     * @param carID
     * @return 评论列表
     */
    @Override
    public List<Discuss> GetCarAllDiscuss(String carID) {
        QueryWrapper<Discuss> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("carID",carID);
        return discussMapper.selectList(queryWrapper);
    }

    /***
     * 发表评论
     * @param discuss 评论详情
     * @return 发表成功
     */
    @Override
    public Boolean PublishDiscussion(Discuss discuss) {
        return discussMapper.insert(discuss)==1?true:false;
    }
}
