package com.zhaol.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaol.gateway.entity.User;
import com.zhaol.gateway.mapper.UserMapper;
import com.zhaol.gateway.service.IRoleService;
import com.zhaol.gateway.service.IUserRoleService;
import com.zhaol.gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    IRoleService roleService;

    @Autowired
    IUserRoleService userRoleService;

    @Override
    public User getByAccount(String account) {
        return getOne(new QueryWrapper<User>().lambda().eq(User::getAccount,account));
    }

    @Override
    public List<String> getUserRoles(Long id) {
        List<String> list = new ArrayList<>();
        User user = getById(id);
        if(user == null) {
            return list;
        }
        List<Long> roleIds = userRoleService.selectRoleIdsByUserId(id);
        if(roleIds == null || roleIds.isEmpty()) {
            return list;
        }
        return roleService.selectRoleCodeByIds(roleIds);
    }
}
