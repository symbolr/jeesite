/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 客户评价Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataEvaluate extends DataEntity<DataEvaluate> {
	
	private static final long serialVersionUID = 1L;
	private String workerId;		// 网格员工号
	private String value;		// 得分（星数）
	private String customerNo;		// 客户号
	
	public DataEvaluate() {
		super();
	}

	public DataEvaluate(String id){
		super(id);
	}

	@Length(min=1, max=64, message="网格员工号长度必须介于 1 和 64 之间")
	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	
	@Length(min=1, max=1, message="得分（星数）长度必须介于 1 和 1 之间")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Length(min=1, max=64, message="客户号长度必须介于 1 和 64 之间")
	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
}