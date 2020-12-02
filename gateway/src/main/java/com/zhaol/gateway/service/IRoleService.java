package com.zhaol.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaol.gateway.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
public interface IRoleService extends IService<Role> {

    /**
     * @desc 查询角色编码，通过角色id列表
     * @param ids
     * @return java.util.List<java.lang.String>
     * @author 赵力
     * @date 2020-03-13 16:15:47
     */
    List<String> selectRoleCodeByIds(List<Long> ids);
}
