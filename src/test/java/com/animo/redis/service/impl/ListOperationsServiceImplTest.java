package com.animo.redis.service.impl;

import com.animo.fly.FlyApplicationTests;
import com.animo.fly.entity.User;
import com.animo.redis.service.ListOperationsService;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ListOperationsServiceImplTest extends FlyApplicationTests {

    @Autowired
    private ListOperationsService listOperationsService;

    private List<User> list = new ArrayList<>();

    @InitBinder
    public void initData(){
        for(int i = 0;i<5;++i){
            User user = new User();
            user.setEmail("+"+i+"+");
            list.add(user);
        }
    }

    @Test
    public void leftPushAll() {

        List<User> list = new ArrayList<>();

        for(int i = 0;i<5;++i){
            User user = new User();
            user.setEmail("+"+i+"+");
            list.add(user);
        }

        System.out.println("长度："+listOperationsService.leftPushAll("testList",list));

    }

    @Test
    public void leftPushIfPresent() {

        System.out.println(" 长度："+listOperationsService.leftPushIfPresent("111",list));

    }

    @Test
    public void leftPush() {

        listOperationsService.leftPush("mylist",3,10);

    }

    @Test
    public void set() {

        listOperationsService.set("mylist",10,"1000");

    }

    @Test
    public void leftPop() {

        System.out.println(listOperationsService.leftPop("mylist",10, TimeUnit.HOURS));
        System.out.println(listOperationsService.leftPop("mylist",10, TimeUnit.HOURS));


    }
}