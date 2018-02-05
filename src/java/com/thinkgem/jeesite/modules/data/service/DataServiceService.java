/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataService;
import com.thinkgem.jeesite.modules.data.dao.DataServiceDao;

/**
 * 服务人员信息Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataServiceService extends CrudService<DataServiceDao, DataService> {

	public DataService get(String id) {
		return super.get(id);
	}
	
	public List<DataService> findList(DataService dataService) {
		return super.findList(dataService);
	}
	
	public Page<DataService> findPage(Page<DataService> page, DataService dataService) {
		return super.findPage(page, dataService);
	}
	
	@Transactional(readOnly = false)
	public void save(DataService dataService) {
		super.save(dataService);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataService dataService) {
		super.delete(dataService);
	}
	
}