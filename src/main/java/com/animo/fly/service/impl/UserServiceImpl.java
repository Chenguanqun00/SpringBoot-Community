package com.animo.fly.service.impl;

import com.animo.fly.entity.User;
import com.animo.fly.mapper.UserMapper;
import com.animo.fly.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo
 * @since 2018-09-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUser(String id) {
        System.out.println(id+"进入实现类获取数据！");
        User user = new User();
        user.setId(Long.valueOf(id));
        user.setEmail("邮箱");
        return user;
    }

    @Override
    public void deleteUser(String id) {
        System.out.println(id+"进入实现类删除数据！");
    }


}
