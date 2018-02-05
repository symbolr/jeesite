/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 终端信息Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataTerm extends DataEntity<DataTerm> {
	
	private static final long serialVersionUID = 1L;
	private String hxCode;		// 环信编号
	private String hxName;		// 环信昵称
	private String hxPassword;		// 环信密码
	private String isOpen;		// 是否开放设置界面（1开放，0关闭）
	
	public DataTerm() {
		super();
	}

	public DataTerm(String id){
		super(id);
	}

	@Length(min=1, max=11, message="环信编号长度必须介于 1 和 11 之间")
	public String getHxCode() {
		return hxCode;
	}

	public void setHxCode(String hxCode) {
		this.hxCode = hxCode;
	}
	
	@Length(min=1, max=64, message="环信昵称长度必须介于 1 和 64 之间")
	public String getHxName() {
		return hxName;
	}

	public void setHxName(String hxName) {
		this.hxName = hxName;
	}
	
	@Length(min=1, max=64, message="环信密码长度必须介于 1 和 64 之间")
	public String getHxPassword() {
		return hxPassword;
	}

	public void setHxPassword(String hxPassword) {
		this.hxPassword = hxPassword;
	}
	
	@Length(min=1, max=10, message="是否开放设置界面（1开放，0关闭）长度必须介于 1 和 10 之间")
	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	
}