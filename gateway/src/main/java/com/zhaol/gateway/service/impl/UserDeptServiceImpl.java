package com.zhaol.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaol.gateway.entity.UserDept;
import com.zhaol.gateway.mapper.UserDeptMapper;
import com.zhaol.gateway.service.IUserDeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户部门表 服务实现类
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
@Service
public class UserDeptServiceImpl extends ServiceImpl<UserDeptMapper, UserDept> implements IUserDeptService {

}
