/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataEvaluate;
import com.thinkgem.jeesite.modules.data.dao.DataEvaluateDao;

/**
 * 客户评价Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataEvaluateService extends CrudService<DataEvaluateDao, DataEvaluate> {

	public DataEvaluate get(String id) {
		return super.get(id);
	}
	
	public List<DataEvaluate> findList(DataEvaluate dataEvaluate) {
		return super.findList(dataEvaluate);
	}
	
	public Page<DataEvaluate> findPage(Page<DataEvaluate> page, DataEvaluate dataEvaluate) {
		return super.findPage(page, dataEvaluate);
	}
	
	@Transactional(readOnly = false)
	public void save(DataEvaluate dataEvaluate) {
		super.save(dataEvaluate);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataEvaluate dataEvaluate) {
		super.delete(dataEvaluate);
	}
	
}