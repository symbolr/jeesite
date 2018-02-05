/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CalEnergyTm;
import com.thinkgem.jeesite.modules.cms.dao.CalEnergyTmDao;

/**
 * 电量Service
 * @author 沈波
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class CalEnergyTmService extends CrudService<CalEnergyTmDao, CalEnergyTm> {

	public CalEnergyTm get(String id) {
		return super.get(id);
	}
	
	public List<CalEnergyTm> findList(CalEnergyTm calEnergyTm) {
		return super.findList(calEnergyTm);
	}
	
	public Page<CalEnergyTm> findPage(Page<CalEnergyTm> page, CalEnergyTm calEnergyTm) {
		return super.findPage(page, calEnergyTm);
	}
	
	@Transactional(readOnly = false)
	public void save(CalEnergyTm calEnergyTm) {
		super.save(calEnergyTm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CalEnergyTm calEnergyTm) {
		super.delete(calEnergyTm);
	}
	
}