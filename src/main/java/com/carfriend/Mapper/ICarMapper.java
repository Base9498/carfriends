package com.carfriend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carfriend.Domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface ICarMapper extends BaseMapper<Car> {

    /***
     * 查询所有车辆信息
     * @return 车辆信息列表
     */
    List<Car> GetCarInfos();

    /***
     * 获取某个品牌的所有车型
     * @param brandName 品牌名
     * @return 该品牌的车辆列表
     */
    List<Car> FindCarsByBrand(String brandName);

}
