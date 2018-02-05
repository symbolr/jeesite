/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 日志Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataSyslog extends DataEntity<DataSyslog> {
	
	private static final long serialVersionUID = 1L;
	private String termId;		// 设备编号，终端或APP
	private String termType;		// 类型 ，1 终端的，2 App的
	private String file;		// 文件地址，上传的文件存到硬盘上
	private Date sysDate;		// 系统产生日志时间
	
	public DataSyslog() {
		super();
	}

	public DataSyslog(String id){
		super(id);
	}

	@Length(min=1, max=64, message="设备编号，终端或APP长度必须介于 1 和 64 之间")
	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}
	
	@Length(min=1, max=1, message="类型 ，1 终端的，2 App的长度必须介于 1 和 1 之间")
	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}
	
	@Length(min=1, max=64, message="文件地址，上传的文件存到硬盘上长度必须介于 1 和 64 之间")
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="系统产生日志时间不能为空")
	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
	
}