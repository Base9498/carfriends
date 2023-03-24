package com.carfriend.Controller;

import com.carfriend.Domain.Car;
import com.carfriend.Service.IBindService;
import com.carfriend.Service.ICarService;
import com.carfriend.Util.Code;
import com.carfriend.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/***
 * 车辆事务相关
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;

    /***
     * 获取所有车辆信息
     * @return 车辆列表
     */
    @GetMapping("/getAllCar")
    public Result GetAllCarInfos() {
        List<Car> cars = carService.GetCarInfos();
        return new Result(Code.SUCCESS, cars, "获取成功");
    }

    /***
     * 查询指定品牌的车辆
     * @param brandName 品牌名
     * @return 车辆列表
     */
    @GetMapping("/getBrandCar/{brandName}")
    public Result GetCarInfosByBrand(@PathVariable("brandName") String brandName){
        List<Car> cars = carService.FindCarsByBrand(brandName);
        if(!cars.isEmpty())
            return new Result(Code.SUCCESS,cars,"查询成功");
        return new Result(Code.ERROR,"没有该品牌的车辆信息");
    }

    /***
     * 点赞车辆
     * @param carID 车辆id
     * @return 点赞成功结果
     */
    @GetMapping("/likeCar/{carID}")
    public Result LikeCar(@PathVariable("carID") String carID){
        Boolean success = carService.LikeCar(carID);
        if(success)
            return new Result(Code.SUCCESS,success,"点赞成功");
        return new Result(Code.ERROR,success,"点赞失败");
    }

}


