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
     * 通过品牌获取指定车辆
     * @param brandName 品牌名
     * @return  该品牌的车辆列表
     */
    @Override
    public List<Car> FindCarsByBrand(String brandName) {
        //TODO：多表查询
        return carMapper.FindCarsByBrand(brandName);
    }

    /***
     * 点赞指定车辆
     * @param carID 车辆id
     * @return 点赞结果
     */
    @Override
    public Boolean LikeCar(String carID) {
        QueryWrapper<Car> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",carID);
        Car car = carMapper.selectOne(queryWrapper);
        long like=car.getCarLike();
        like+=1;
        car.setCarLike(like);
        return carMapper.updateById(car)==1?true:false;
    }


}
