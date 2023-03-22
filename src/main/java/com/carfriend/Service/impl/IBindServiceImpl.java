package com.carfriend.Service.impl;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carfriend.Domain.Bind;
import com.carfriend.Mapper.IBindMapper;
import com.carfriend.Service.IBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBindServiceImpl extends ServiceImpl<IBindMapper, Bind> implements IBindService {

    @Autowired
    private IBindMapper bindMapper;

    /***
     * 用户绑定车辆
     * @param bind 绑定信息
     * @return 绑定结果
     */
    @Override
    public Boolean BindCar(Bind bind) {
        return bindMapper.insert(bind)==1?true:false;
    }

    /***
     * 该用户是否已经绑定过车辆
     * @param userID 用户id
     * @return 查询结果，true即为已绑定过
     */
    @Override
    public Boolean HadBounce(String userID) {
        QueryWrapper<Bind> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userID",userID);
        return bindMapper.selectList(queryWrapper).size()>=1?true:false;
    }
}
