package com.zhaol.gateway.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户部门表
 * </p>
 *
 * @author 赵力
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("base_user_dept")
public class UserDept extends Model<UserDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private Long id;

    /**
     * 用户ID
     */
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private Long userid;

    /**
     * 部门ID
     */
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private Long deptid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 创建部门
     */
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @TableField(fill = FieldFill.INSERT)
    private Long createDept;

    /**
     * 创建时间
     */
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 更新时间
     */
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 业务状态
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    /**
     * 是否已删除
     */
    @TableLogic
    private Integer isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
