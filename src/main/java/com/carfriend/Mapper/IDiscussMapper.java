package com.carfriend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carfriend.Domain.Discuss;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDiscussMapper extends BaseMapper<Discuss> {
    List<Discuss> FindDiscussByUser(String userID);

}
