/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.CalEnergyTm;

/**
 * 电量DAO接口
 * @author 沈波
 * @version 2017-06-01
 */
@MyBatisDao
public interface CalEnergyTmDao extends CrudDao<CalEnergyTm> {
	
}