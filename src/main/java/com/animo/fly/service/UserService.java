package com.animo.fly.service;

import com.animo.fly.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo
 * @since 2018-09-10
 */
public interface UserService extends IService<User> {

    @Cacheable(key="'user_'+#id",value="'user'+#id")
    User getUser(String id);

    @CacheEvict(key="'user_'+#id", value="users", condition="#id!=1")
    void deleteUser(String id);



}
