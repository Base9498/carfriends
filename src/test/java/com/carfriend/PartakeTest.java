package com.carfriend;

import com.carfriend.Domain.Partake;
import com.carfriend.Mapper.IPartakeMapper;
import com.carfriend.Service.impl.IPartakeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PartakeTest {
    @Autowired
    private IPartakeServiceImpl partakeService;
    @Autowired
    private IPartakeMapper partakeMapper;

    @Test
    void TestJoinPartake(){
//        System.out.println(partakeService.JoinPartake("10000001","69400002"));
    }

    @Test
    void TestFindAllPartake(){
        System.out.println(partakeService.FindAllPartake("10000001"));
    }

    @Test
    void FindUserPartake(){
        System.out.println(partakeService.FindAllPartake("10000001").size());
//        System.out.println(partakeMapper.FindPartakeByUserone("10000001"));
    }
}
