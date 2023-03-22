package com.carfriend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carfriend.Domain.Partake;
import com.carfriend.Mapper.IPartakeMapper;
import com.carfriend.Service.IPartakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IPartakeServiceImpl extends ServiceImpl<IPartakeMapper, Partake> implements IPartakeService {

    @Autowired
    private IPartakeMapper partakeMapper;
    /***
     * 参与活动
     * @param partake 活动信息
     * @return 参与是否成功
     */
    @Override
    public Boolean JoinPartake(Partake partake) {
        return partakeMapper.insert(partake)==1?true:false;
    }

    /***
     * 查询已参加的活动
     * @param userID 用户ID
     * @return 已参与过的活动列表
     */
    @Override
    public List<Partake> FindAllPartake(String userID) {
        QueryWrapper<Partake> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userID",userID);
        return partakeMapper.selectList(queryWrapper);
    }
}
