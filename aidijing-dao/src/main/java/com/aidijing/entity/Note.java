package com.aidijing.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 笔记
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
public class Note extends Model<Note> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 作者
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 标题
     */
	private String title;
    /**
     * 副标题
     */
	private String subtitle;
    /**
     * 内容
     */
	private String content;
    /**
     * 类型NOTE:笔记，ARTICLE:文章)【默认:NOTE】 
     */
	private String type;
    /**
     * 类别
     */
	private String category;
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

	public Note setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public Note setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Note setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public Note setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Note setContent(String content) {
		this.content = content;
		return this;
	}

	public String getType() {
		return type;
	}

	public Note setType(String type) {
		this.type = type;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public Note setCategory(String category) {
		this.category = category;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Note setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Note setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public String getTableState() {
		return tableState;
	}

	public Note setTableState(String tableState) {
		this.tableState = tableState;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Note setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
