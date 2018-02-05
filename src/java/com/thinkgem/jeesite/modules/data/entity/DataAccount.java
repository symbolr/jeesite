/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户账户Entity
 * @author 沈 波
 * @version 2017-07-21
 */
public class DataAccount extends DataEntity<DataAccount> {
	
	private static final long serialVersionUID = 1L;
	private String customerNo;		// 客户编号
	private String customerName;		// 客户名
	private String customerUnit;		// 网格号
	private String customerAddress;		// 用电地址
	private String settleNo;		// 结算户号
	private String ewatchNo;		// 电表识别号
	private String ewatchAdress;		// 电表安装地址
	private String balance;		// 用户余额
	private String lastBanlance;		// 最近缴费金额
	private String duePay;		// 本月总电费
	private String totalPenal;		// 总违约金
	private String totalEnerge;		// 本月总用电量
	private String isAllpay;		// 全收费标志 1 1须一次交清 0可分多次
	private String cardMark;		// 标记安装进度，从1到9
	private String maxCharge;		// 最大可充电量 4 字段12为1时有效，表示客户在不交费的情况下允许的可充电量
	
	public DataAccount() {
		super();
	}

	public DataAccount(String id){
		super(id);
	}

	@Length(min=1, max=64, message="客户编号长度必须介于 1 和 64 之间")
	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	@Length(min=1, max=64, message="客户名长度必须介于 1 和 64 之间")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Length(min=1, max=64, message="网格号长度必须介于 1 和 64 之间")
	public String getCustomerUnit() {
		return customerUnit;
	}

	public void setCustomerUnit(String customerUnit) {
		this.customerUnit = customerUnit;
	}
	
	@Length(min=1, max=64, message="用电地址长度必须介于 1 和 64 之间")
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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
	
	@Length(min=1, max=64, message="电表安装地址长度必须介于 1 和 64 之间")
	public String getEwatchAdress() {
		return ewatchAdress;
	}

	public void setEwatchAdress(String ewatchAdress) {
		this.ewatchAdress = ewatchAdress;
	}
	
	@Length(min=1, max=10, message="用户余额长度必须介于 1 和 10 之间")
	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	@Length(min=1, max=10, message="最近缴费金额长度必须介于 1 和 10 之间")
	public String getLastBanlance() {
		return lastBanlance;
	}

	public void setLastBanlance(String lastBanlance) {
		this.lastBanlance = lastBanlance;
	}
	
	@Length(min=1, max=10, message="本月总电费长度必须介于 1 和 10 之间")
	public String getDuePay() {
		return duePay;
	}

	public void setDuePay(String duePay) {
		this.duePay = duePay;
	}
	
	@Length(min=1, max=10, message="总违约金长度必须介于 1 和 10 之间")
	public String getTotalPenal() {
		return totalPenal;
	}

	public void setTotalPenal(String totalPenal) {
		this.totalPenal = totalPenal;
	}
	
	@Length(min=1, max=10, message="本月总用电量长度必须介于 1 和 10 之间")
	public String getTotalEnerge() {
		return totalEnerge;
	}

	public void setTotalEnerge(String totalEnerge) {
		this.totalEnerge = totalEnerge;
	}
	
	@Length(min=1, max=1, message="全收费标志 1 1须一次交清 0可分多次长度必须介于 1 和 1 之间")
	public String getIsAllpay() {
		return isAllpay;
	}

	public void setIsAllpay(String isAllpay) {
		this.isAllpay = isAllpay;
	}
	
	@Length(min=1, max=10, message="标记安装进度，从1到9长度必须介于 1 和 10 之间")
	public String getCardMark() {
		return cardMark;
	}

	public void setCardMark(String cardMark) {
		this.cardMark = cardMark;
	}
	
	@Length(min=1, max=64, message="最大可充电量 4 字段12为1时有效，表示客户在不交费的情况下允许的可充电量长度必须介于 1 和 64 之间")
	public String getMaxCharge() {
		return maxCharge;
	}

	public void setMaxCharge(String maxCharge) {
		this.maxCharge = maxCharge;
	}
	
}