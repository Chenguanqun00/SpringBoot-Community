package com.animo.fly.controller;


import com.animo.common.result.ServerResponse;
import com.animo.fly.entity.User;
import com.animo.fly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo
 * @since 2018-09-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("reg")
    public ServerResponse reg(@RequestBody User user){
        return null;
    }

}

