/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataContact;
import com.thinkgem.jeesite.modules.data.dao.DataContactDao;

/**
 * 短信联系人管理Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataContactService extends CrudService<DataContactDao, DataContact> {

	public DataContact get(String id) {
		return super.get(id);
	}
	
	public List<DataContact> findList(DataContact dataContact) {
		return super.findList(dataContact);
	}
	
	public Page<DataContact> findPage(Page<DataContact> page, DataContact dataContact) {
		return super.findPage(page, dataContact);
	}
	
	@Transactional(readOnly = false)
	public void save(DataContact dataContact) {
		super.save(dataContact);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataContact dataContact) {
		super.delete(dataContact);
	}
	
}