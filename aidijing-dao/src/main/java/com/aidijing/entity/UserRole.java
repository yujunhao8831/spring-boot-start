package com.aidijing.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 用户角色中间表
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
@TableName( "user_role" )
public class UserRole extends Model< UserRole > {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId( value = "id", type = IdType.AUTO )
    private Long id;

    @TableField( "user_id" )
    private Long userId;
    @TableField( "role_id" )
    private Long roleId;


    public Long getUserId () {
        return userId;
    }

    public UserRole setUserId ( Long userId ) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId () {
        return roleId;
    }

    public UserRole setRoleId ( Long roleId ) {
        this.roleId = roleId;
        return this;
    }

    @Override
    protected Serializable pkVal () {
        return this.id;
    }

}
