package com.carfriend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carfriend.Domain.Car;
import com.carfriend.Mapper.ICarMapper;
import com.carfriend.Service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICarServiceImpl extends ServiceImpl<ICarMapper,Car> implements ICarService {

    @Autowired
    private ICarMapper carMapper;
    /***
     * 查询所有车辆信息
     * @return 车辆信息列表
     */
    @Override
    public List<Car> GetCarInfos() {
        return carMapper.GetCarInfos();
    }

    /***
     * 用户绑定车辆信息，除管理员外 每个用户至多绑定一台车
     * @param car 车辆信息
     * @return 绑定是否成功
     */
    @Override
    public Boolean BindCarByUser(Car car) {
        return carMapper.BindCar(car)==1?true:false;
    }

    /***
     * 用户是否已经绑定过一台车辆了
     * @param userID 用户id
     * @return true为已绑定过，false即未绑定过
     */
    @Override
    public Boolean UserHadBound(String userID) {
        QueryWrapper<Car> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userID",userID);
        return carMapper.selectOne(queryWrapper)!=null?true:false;
    }

    @Override
    public Car FindCarByUserID(String userID) {
        return carMapper.FindCarByUser(userID);
    }


}
