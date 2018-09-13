package com.animo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/9/5
 */
@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping("admin/login.do")
    public String adminLogin() {
        return "admin/login" ;
    }

    @GetMapping("user/reg")
    public String userReg() {
        return "user/reg" ;
    }

    @GetMapping("user/login")
    public String userLogin() {
        return "user/login" ;
    }
}
