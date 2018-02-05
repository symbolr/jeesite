/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataUpfile;
import com.thinkgem.jeesite.modules.data.dao.DataUpfileDao;

/**
 * 升级文件Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataUpfileService extends CrudService<DataUpfileDao, DataUpfile> {

	public DataUpfile get(String id) {
		return super.get(id);
	}
	
	public List<DataUpfile> findList(DataUpfile dataUpfile) {
		return super.findList(dataUpfile);
	}
	
	public Page<DataUpfile> findPage(Page<DataUpfile> page, DataUpfile dataUpfile) {
		return super.findPage(page, dataUpfile);
	}
	
	@Transactional(readOnly = false)
	public void save(DataUpfile dataUpfile) {
		super.save(dataUpfile);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataUpfile dataUpfile) {
		super.delete(dataUpfile);
	}
	
}