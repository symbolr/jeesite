/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataOperate;
import com.thinkgem.jeesite.modules.data.dao.DataOperateDao;

/**
 * 操作记录Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataOperateService extends CrudService<DataOperateDao, DataOperate> {

	public DataOperate get(String id) {
		return super.get(id);
	}
	
	public List<DataOperate> findList(DataOperate dataOperate) {
		return super.findList(dataOperate);
	}
	
	public Page<DataOperate> findPage(Page<DataOperate> page, DataOperate dataOperate) {
		return super.findPage(page, dataOperate);
	}
	
	@Transactional(readOnly = false)
	public void save(DataOperate dataOperate) {
		super.save(dataOperate);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataOperate dataOperate) {
		super.delete(dataOperate);
	}
	
}