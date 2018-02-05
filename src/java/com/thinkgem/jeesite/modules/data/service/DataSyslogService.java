/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.data.entity.DataSyslog;
import com.thinkgem.jeesite.modules.data.dao.DataSyslogDao;

/**
 * 日志Service
 * @author 沈波
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class DataSyslogService extends CrudService<DataSyslogDao, DataSyslog> {

	public DataSyslog get(String id) {
		return super.get(id);
	}
	
	public List<DataSyslog> findList(DataSyslog dataSyslog) {
		return super.findList(dataSyslog);
	}
	
	public Page<DataSyslog> findPage(Page<DataSyslog> page, DataSyslog dataSyslog) {
		return super.findPage(page, dataSyslog);
	}
	
	@Transactional(readOnly = false)
	public void save(DataSyslog dataSyslog) {
		super.save(dataSyslog);
	}
	
	@Transactional(readOnly = false)
	public void delete(DataSyslog dataSyslog) {
		super.delete(dataSyslog);
	}
	
}