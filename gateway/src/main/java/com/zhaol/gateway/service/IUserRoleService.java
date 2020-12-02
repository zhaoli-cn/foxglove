package com.zhaol.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaol.gateway.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * @desc 查询角色ID,通过用户ID
     * @param userid
     * @return java.util.List<java.lang.Long>
     * @author 赵力
     * @date 2020-03-13 16:15:03
     */
    List<Long> selectRoleIdsByUserId(Long userid);
}
