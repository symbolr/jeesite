/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataTerm;
import com.thinkgem.jeesite.modules.data.dao.DataTermDao;

/**
 * 终端信息Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataTermService extends CrudService<DataTermDao, DataTerm> {

	public DataTerm get(String id) {
		return super.get(id);
	}
	
	public List<DataTerm> findList(DataTerm dataTerm) {
		return super.findList(dataTerm);
	}
	
	public Page<DataTerm> findPage(Page<DataTerm> page, DataTerm dataTerm) {
		return super.findPage(page, dataTerm);
	}
	
	@Transactional(readOnly = false)
	public void save(DataTerm dataTerm) {
		super.save(dataTerm);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataTerm dataTerm) {
		super.delete(dataTerm);
	}
	
}