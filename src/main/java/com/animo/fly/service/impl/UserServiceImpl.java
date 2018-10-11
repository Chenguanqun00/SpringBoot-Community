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
 * @since 2018-10-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
