package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.Car;

import java.util.List;

public interface ICarService extends IService<Car> {

    List<Car> GetCarInfos();

    Boolean BindCarByUser(Car car);

    Boolean UserHadBound(String userID);

    Car FindCarByUserID(String userID);
}
