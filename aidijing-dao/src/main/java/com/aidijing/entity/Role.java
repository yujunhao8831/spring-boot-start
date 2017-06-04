package com.aidijing.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 角色名称core
     */
	@TableField("role_name_code")
	private String roleNameCode;
    /**
     * 描述
     */
	private String description;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 备注
     */
	private String remark;


	public Long getId() {
		return id;
	}

	public Role setId(Long id) {
		this.id = id;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public Role setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public String getRoleNameCode() {
		return roleNameCode;
	}

	public Role setRoleNameCode(String roleNameCode) {
		this.roleNameCode = roleNameCode;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Role setDescription(String description) {
		this.description = description;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Role setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Role setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Role setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
