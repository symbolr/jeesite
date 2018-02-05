/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.ActEntity;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 公共信息Entity
 * @author 沈波
 * @version 2017-08-03
 */
public class OaPubinfo extends ActEntity<OaPubinfo> {
	
	private static final long serialVersionUID = 1L;
	
	private User user;		// 变动用户
	private Office office;		// 归属机构
	private String content;		// 信息内容
	private String adminText;		// 管理员意见
	
	public OaPubinfo() {
		super();
	}

	public OaPubinfo(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="信息内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=255, message="管理员意见长度必须介于 0 和 255 之间")
	public String getAdminText() {
		return adminText;
	}

	public void setAdminText(String adminText) {
		this.adminText = adminText;
	}
	
}