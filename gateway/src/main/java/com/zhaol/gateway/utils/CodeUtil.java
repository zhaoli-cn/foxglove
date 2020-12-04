package com.zhaol.gateway.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 编码工具类
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/4 11:01
 */
public class CodeUtil {

    /**
     * 对密码进行Bcrypt加密
     * @param password
     * @return java.lang.String
     * @author 赵力
     * @date 2020-12-04 14:54:35
    */
    public static String encodeBcrypt(String password) {
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        return encode.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(encodeBcrypt("123456"));
    }
}
