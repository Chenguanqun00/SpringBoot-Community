package com.animo.fly;

import com.animo.FlyApplication;
import com.animo.fly.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlyApplication.class)
public class FlyApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j++;
        }
        System.out.println(j);
    }

    public static void main(String[] args) {

    }

}
