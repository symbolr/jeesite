/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataAccount;
import com.thinkgem.jeesite.modules.data.dao.DataAccountDao;

/**
 * 用户账户Service
 * @author 沈 波
 * @version 2017-07-21
 */
@Service
@Transactional(readOnly = true)
public class DataAccountService extends CrudService<DataAccountDao, DataAccount> {

	public DataAccount get(String id) {
		return super.get(id);
	}
	
	public List<DataAccount> findList(DataAccount dataAccount) {
		return super.findList(dataAccount);
	}
	
	public Page<DataAccount> findPage(Page<DataAccount> page, DataAccount dataAccount) {
		return super.findPage(page, dataAccount);
	}
	
	@Transactional(readOnly = false)
	public void save(DataAccount dataAccount) {
		super.save(dataAccount);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataAccount dataAccount) {
		super.delete(dataAccount);
	}
	
}