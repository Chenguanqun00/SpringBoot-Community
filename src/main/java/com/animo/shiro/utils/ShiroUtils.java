package com.animo.shiro.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by Animo on 2017-12-07.
 */
public class ShiroUtils {


    /**
     * shiro密码加密
     *
     * @param password
     * @param salt
     * @return
     */
    public static String md5(String password, String salt) {
        return new SimpleHash("md5", password, salt, 1024).toString();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取Subject
     *
     * @return
     */
    public static Subject getSubJect() {
        return SecurityUtils.getSubject();
    }

}
