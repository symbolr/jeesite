/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 升级文件Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataUpfile extends DataEntity<DataUpfile> {
	
	private static final long serialVersionUID = 1L;
	private String termType;		// 设备类型，1终端的升级文件 2 APP的升级文件
	private String file;		// 升级文件地址
	private String version;		// 升级文件版本
	
	public DataUpfile() {
		super();
	}

	public DataUpfile(String id){
		super(id);
	}

	@Length(min=1, max=1, message="设备类型，1终端的升级文件 2 APP的升级文件长度必须介于 1 和 1 之间")
	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}
	
	@Length(min=1, max=64, message="升级文件地址长度必须介于 1 和 64 之间")
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	@Length(min=1, max=64, message="升级文件版本长度必须介于 1 和 64 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}