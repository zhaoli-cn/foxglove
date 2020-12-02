package com.zhaol.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaol.gateway.entity.UserRole;
import com.zhaol.gateway.mapper.UserRoleMapper;
import com.zhaol.gateway.service.IUserRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public List<Long> selectRoleIdsByUserId(Long userid) {
        List<Long> list = new ArrayList<>();
        List<UserRole> userRoles = this.list(new QueryWrapper<UserRole>().lambda().eq(UserRole::getUserid,userid));
        if(userRoles != null){
           list = userRoles.stream().map(a -> a.getRoleid()).collect(Collectors.toList());
        }
        return list;
    }
}
