package com.zhaol.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaol.gateway.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
@CacheConfig(cacheNames = "USER")
public interface IUserService extends IService<User> {

    /**
     * @desc 根据昵称查询用户
     * @param account
     * @return com.fennel.gateway.entity.User
     * @author 赵力
     * @date 2020-03-13 10:45:40
     */
    @Cacheable(value = "users",key = "#account")
    User getByAccount(String account);

    /**
     * @desc 查询用户角色列表
     * @param id
     * @return java.util.List<java.lang.String>
     * @author 赵力
     * @date 2020-03-13 10:45:57
     */
    @Cacheable(value = "roles",key = "#id")
    List<String> getUserRoles(Long id);
}
