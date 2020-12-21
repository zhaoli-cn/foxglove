package com.zhaol.gateway.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 安全验证的用户实体对象
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/2 15:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MyUser extends User {

    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private Long id;
    private String mobile;
    private String identity;
    private String name;
    private String account;
    private String nickName;

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities,Long id, String identity, String account, String name, String nickName, String mobile) {
        super(username, password, authorities);
        this.id = id;
        this.identity = identity;
        this.name = name;
        this.mobile = mobile;
        this.account = account;
        this.nickName = nickName;
    }

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
