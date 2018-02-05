/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataOwes;
import com.thinkgem.jeesite.modules.data.dao.DataOwesDao;

/**
 * 欠费详情Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataOwesService extends CrudService<DataOwesDao, DataOwes> {

	public DataOwes get(String id) {
		return super.get(id);
	}
	
	public List<DataOwes> findList(DataOwes dataOwes) {
		return super.findList(dataOwes);
	}
	
	public Page<DataOwes> findPage(Page<DataOwes> page, DataOwes dataOwes) {
		return super.findPage(page, dataOwes);
	}
	
	@Transactional(readOnly = false)
	public void save(DataOwes dataOwes) {
		super.save(dataOwes);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataOwes dataOwes) {
		super.delete(dataOwes);
	}
	
}