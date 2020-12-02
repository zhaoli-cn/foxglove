package com.zhaol.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaol.gateway.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
public interface IUserService extends IService<User> {

    /**
     * @desc 根据昵称查询用户
     * @param account
     * @return com.fennel.gateway.entity.User
     * @author 赵力
     * @date 2020-03-13 10:45:40
     */
    User getByAccount(String account);

    /**
     * @desc 查询用户角色列表
     * @param id
     * @return java.util.List<java.lang.String>
     * @author 赵力
     * @date 2020-03-13 10:45:57
     */
    List<String> getUserRoles(Long id);
}
