package com.carfriend.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carfriend.Domain.Bind;

public interface IBindService extends IService<Bind> {

     Boolean BindCar(Bind bind);

     Boolean HadBounce(String userID);
}
