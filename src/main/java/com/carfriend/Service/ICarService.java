package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.Car;

import java.util.List;

public interface ICarService extends IService<Car> {

    List<Car> GetCarInfos();

    List<Car> FindCarsByBrand(String brandName);

    Boolean LikeCar(String carID);
}
