/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataPush;
import com.thinkgem.jeesite.modules.data.dao.DataPushDao;

/**
 * 公共信息发布表Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataPushService extends CrudService<DataPushDao, DataPush> {

	public DataPush get(String id) {
		return super.get(id);
	}
	
	public List<DataPush> findList(DataPush dataPush) {
		return super.findList(dataPush);
	}
	
	public Page<DataPush> findPage(Page<DataPush> page, DataPush dataPush) {
		return super.findPage(page, dataPush);
	}
	
	@Transactional(readOnly = false)
	public void save(DataPush dataPush) {
		super.save(dataPush);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataPush dataPush) {
		super.delete(dataPush);
	}
	
}