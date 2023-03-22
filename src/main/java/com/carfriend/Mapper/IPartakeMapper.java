package com.carfriend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carfriend.Domain.Partake;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IPartakeMapper extends BaseMapper<Partake> {
    List<Partake> FindPartakeByUser(String userID);
}
