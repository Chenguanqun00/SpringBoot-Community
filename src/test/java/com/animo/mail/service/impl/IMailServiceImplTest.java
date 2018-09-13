package com.animo.mail.service.impl;

import com.animo.fly.FlyApplicationTests;
import com.animo.mail.entity.SimpleEntity;
import com.animo.mail.service.IMailService;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class IMailServiceImplTest extends FlyApplicationTests {

    @Autowired
    private IMailService iMailService;

    @Test
    public void sendSimpleMail() {

        SimpleEntity entity = new SimpleEntity();

        String[] to = {""};

        entity.setTo(to);

        entity.setSubject("测试邮箱");

        entity.setText("测试内容");

        iMailService.sendSimpleMail(entity);

    }
}