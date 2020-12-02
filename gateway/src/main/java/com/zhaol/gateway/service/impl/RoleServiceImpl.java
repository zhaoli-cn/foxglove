package com.zhaol.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaol.gateway.entity.Role;
import com.zhaol.gateway.mapper.RoleMapper;
import com.zhaol.gateway.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<String> selectRoleCodeByIds(List<Long> ids) {
        List<String> codes = new ArrayList<>();
        List<Role> roles = this.list(new QueryWrapper<Role>().lambda().in(Role::getId,ids));
        if(roles != null) {
            codes = roles.stream().map(e -> e.getCode()).collect(Collectors.toList());
        }
        return codes;
    }
}
