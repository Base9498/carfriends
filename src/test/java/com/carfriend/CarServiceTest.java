package com.carfriend;

import com.carfriend.Domain.Brand;
import com.carfriend.Domain.Car;
import com.carfriend.Domain.User;
import com.carfriend.Service.ICarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarServiceTest {
    @Autowired
    private ICarService carService;

    @Test
    void TestGetAllCarInfos(){
        System.out.println(carService.GetCarInfos());
    }

    @Test
    void TestHadBound(){
        System.out.println(carService.UserHadBound("10589743"));
    }

    @Test
    void TestBindCar(){
        Car car=new Car();
        car.setCarName("凯迪拉克CT6 铂金版");
        car.setCarLevel("行政级轿车");
        car.setCarPrice("29万");
        car.setCarEngine("2.0T");
        car.setCarBox("12AT");
        car.setCarPower("260匹");
        car.setUserID(10000001L);
        car.setCarBrand(57100014L);
        System.out.println(carService.BindCarByUser(car));
    }

    @Test
    void TestFindCarByUserID(){
        System.out.println(carService.FindCarByUserID("10000001"));
    }
}
