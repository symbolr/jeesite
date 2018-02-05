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
 * 缴费交易Entity
 * @author 沈波
 * @version 2017-07-24
 */
public class DataTrans extends DataEntity<DataTrans> {
	
	private static final long serialVersionUID = 1L;
	private String termId;		// 终端编号
	private String termWaste;		// 终端流水号
	private String batchNo;		// 批次号
	private String customerNo;		// 客户编号
	private String customerName;		// 客户名称
	private String customerAddress;		// 用电地址
	private String businessType;		// 交易类型0	缴费1购电
	private String payType;		// 支付类型0	支付宝支付1	微信支付
	private String settleNo;		// 结算户号
	private String ewatchNo;		// 电表识别号
	private String transWaste;		// 交易流水号,系统产生
	private String transAmount;		// 交易金额
	private Date transDate;		// 交易日期yyyyMMdd
	private Date transBegintime;		// 交易开始时间（yyyy-MM-dd HH:mm:ss）
	private Date transEndtime;		// 交易结束时间（yyyy-MM-dd HH:mm:ss
	private String transState;		// 交易状态0	未发生交易1	交易超时2	交易成功3交易失败
	
	public DataTrans() {
		super();
	}

	public DataTrans(String id){
		super(id);
	}

	@Length(min=1, max=64, message="终端编号长度必须介于 1 和 64 之间")
	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}
	
	@Length(min=1, max=64, message="终端流水号长度必须介于 1 和 64 之间")
	public String getTermWaste() {
		return termWaste;
	}

	public void setTermWaste(String termWaste) {
		this.termWaste = termWaste;
	}
	
	@Length(min=1, max=64, message="批次号长度必须介于 1 和 64 之间")
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	@Length(min=1, max=64, message="客户编号长度必须介于 1 和 64 之间")
	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	@Length(min=1, max=64, message="客户名称长度必须介于 1 和 64 之间")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Length(min=1, max=64, message="用电地址长度必须介于 1 和 64 之间")
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Length(min=1, max=1, message="交易类型0	缴费1购电长度必须介于 1 和 1 之间")
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	@Length(min=1, max=1, message="支付类型0	支付宝支付1	微信支付长度必须介于 1 和 1 之间")
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	@Length(min=1, max=64, message="结算户号长度必须介于 1 和 64 之间")
	public String getSettleNo() {
		return settleNo;
	}

	public void setSettleNo(String settleNo) {
		this.settleNo = settleNo;
	}
	
	@Length(min=1, max=64, message="电表识别号长度必须介于 1 和 64 之间")
	public String getEwatchNo() {
		return ewatchNo;
	}

	public void setEwatchNo(String ewatchNo) {
		this.ewatchNo = ewatchNo;
	}
	
	@Length(min=1, max=64, message="交易流水号,系统产生长度必须介于 1 和 64 之间")
	public String getTransWaste() {
		return transWaste;
	}

	public void setTransWaste(String transWaste) {
		this.transWaste = transWaste;
	}
	
	@Length(min=1, max=64, message="交易金额长度必须介于 1 和 64 之间")
	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="交易日期yyyyMMdd不能为空")
	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="交易开始时间（yyyy-MM-dd HH:mm:ss）不能为空")
	public Date getTransBegintime() {
		return transBegintime;
	}

	public void setTransBegintime(Date transBegintime) {
		this.transBegintime = transBegintime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="交易结束时间（yyyy-MM-dd HH:mm:ss不能为空")
	public Date getTransEndtime() {
		return transEndtime;
	}

	public void setTransEndtime(Date transEndtime) {
		this.transEndtime = transEndtime;
	}
	
	@Length(min=1, max=1, message="交易状态0	未发生交易1	交易超时2	交易成功3交易失败长度必须介于 1 和 1 之间")
	public String getTransState() {
		return transState;
	}

	public void setTransState(String transState) {
		this.transState = transState;
	}
	
}