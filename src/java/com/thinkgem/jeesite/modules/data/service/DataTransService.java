/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataTrans;
import com.thinkgem.jeesite.modules.data.dao.DataTransDao;

/**
 * 缴费交易Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataTransService extends CrudService<DataTransDao, DataTrans> {

	public DataTrans get(String id) {
		return super.get(id);
	}
	
	public List<DataTrans> findList(DataTrans dataTrans) {
		return super.findList(dataTrans);
	}
	
	public Page<DataTrans> findPage(Page<DataTrans> page, DataTrans dataTrans) {
		return super.findPage(page, dataTrans);
	}
	
	@Transactional(readOnly = false)
	public void save(DataTrans dataTrans) {
		super.save(dataTrans);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataTrans dataTrans) {
		super.delete(dataTrans);
	}
	
}