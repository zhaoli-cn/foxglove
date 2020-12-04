package com.zhaol.gateway.service;

import com.zhaol.gateway.entity.MyUser;
import com.zhaol.gateway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于安全校验用户信息实现类
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/2 17:19
 */
@Component(value = "myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByAccount(username);
        // 查询数据库操作
        if(user == null){
            throw new UsernameNotFoundException("系统不存在此用户!");
        }else{
            //获取角色
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            List<String> roles = userService.getUserRoles(user.getId());
            if(roles != null && !roles.isEmpty()) {
                for(String role : roles) {
                    authorities.add(new SimpleGrantedAuthority(role));
                }
            }
            // 通过用户名查询数据库获取加密后的密码
            // String password = passwordEncoder.encode(user.getPassword());
            MyUser myUser = new MyUser(username,user.getPassword(),authorities,user.getId(),user.getIdentity(),user.getAccount(),user.getName(),user.getNickName(),user.getMobile());
            return myUser;
        }
    }
}
