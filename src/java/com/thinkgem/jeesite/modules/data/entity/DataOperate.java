/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 操作记录Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataOperate extends DataEntity<DataOperate> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 操作名称
	private String state;		// 操作状态，是否成功等
	private String termId;		// 终端ID
	private User user;		// 操作人
	private Date sysDate;		// 系统时间
	
	public DataOperate() {
		super();
	}

	public DataOperate(String id){
		super(id);
	}

	@Length(min=1, max=64, message="操作名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=10, message="操作状态，是否成功等长度必须介于 0 和 10 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=64, message="终端ID长度必须介于 0 和 64 之间")
	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="系统时间不能为空")
	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
	
}