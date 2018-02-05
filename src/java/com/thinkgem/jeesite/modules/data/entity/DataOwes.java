/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 欠费详情Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataOwes extends DataEntity<DataOwes> {
	
	private static final long serialVersionUID = 1L;
	private String feeMonth;		// 消费月份
	private String feeEnergy;		// 消费电量
	private String ewatchNo;		// 表号
	private String monetary;		// 消费金额
	
	public DataOwes() {
		super();
	}

	public DataOwes(String id){
		super(id);
	}

	@Length(min=1, max=64, message="消费月份长度必须介于 1 和 64 之间")
	public String getFeeMonth() {
		return feeMonth;
	}

	public void setFeeMonth(String feeMonth) {
		this.feeMonth = feeMonth;
	}
	
	@Length(min=1, max=64, message="消费电量长度必须介于 1 和 64 之间")
	public String getFeeEnergy() {
		return feeEnergy;
	}

	public void setFeeEnergy(String feeEnergy) {
		this.feeEnergy = feeEnergy;
	}
	
	@Length(min=1, max=64, message="表号长度必须介于 1 和 64 之间")
	public String getEwatchNo() {
		return ewatchNo;
	}

	public void setEwatchNo(String ewatchNo) {
		this.ewatchNo = ewatchNo;
	}
	
	@Length(min=1, max=10, message="消费金额长度必须介于 1 和 10 之间")
	public String getMonetary() {
		return monetary;
	}

	public void setMonetary(String monetary) {
		this.monetary = monetary;
	}
	
}