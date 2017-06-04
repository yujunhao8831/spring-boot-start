package com.aidijing.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 电子邮箱
     */
	private String email;
    /**
     * 手机号码
     */
	private String phone;
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
     * 表状态
     */
	@TableField("table_state")
	private String tableState;
    /**
     * 账户状态
     */
	@TableField("user_state")
	private String userState;
    /**
     * 备注
     */
	private String remark;


	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getNickName() {
		return nickName;
	}

	public User setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public User setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public String getTableState() {
		return tableState;
	}

	public User setTableState(String tableState) {
		this.tableState = tableState;
		return this;
	}

	public String getUserState() {
		return userState;
	}

	public User setUserState(String userState) {
		this.userState = userState;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public User setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
