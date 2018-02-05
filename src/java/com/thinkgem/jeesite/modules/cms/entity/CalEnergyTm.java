/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 电量Entity
 * @author 沈波
 * @version 2017-06-01
 */
public class CalEnergyTm extends DataEntity<CalEnergyTm> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	
	public CalEnergyTm() {
		super();
	}

	public CalEnergyTm(String id){
		super(id);
	}

	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}