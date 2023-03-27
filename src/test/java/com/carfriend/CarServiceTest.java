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
    void TestFindCarsByBrand(){
        System.out.println(carService.FindCarsByBrand("L"));
    }

    @Test
    void TestLike(){
        System.out.println(carService.LikeCar("27100013"));
    }
}
