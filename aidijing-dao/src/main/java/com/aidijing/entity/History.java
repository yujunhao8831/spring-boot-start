package com.aidijing.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 历史记录
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
public class History extends Model<History> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 操作类型
     */
	private String action;
    /**
     * 操作状态
     */
	@TableField("action_status")
	private String actionStatus;
    /**
     * 地址
     */
	@TableField("ip_address")
	private String ipAddress;
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
     * 备注
     */
	private String remark;


	public Long getId() {
		return id;
	}

	public History setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public History setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getAction() {
		return action;
	}

	public History setAction(String action) {
		this.action = action;
		return this;
	}

	public String getActionStatus() {
		return actionStatus;
	}

	public History setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
		return this;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public History setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public History setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public History setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public String getTableState() {
		return tableState;
	}

	public History setTableState(String tableState) {
		this.tableState = tableState;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public History setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
