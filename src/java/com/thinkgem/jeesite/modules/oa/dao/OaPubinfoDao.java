/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.oa.entity.OaPubinfo;
import com.thinkgem.jeesite.modules.oa.entity.TestAudit;

/**
 * 公共信息DAO接口
 * @author 沈波
 * @version 2017-08-03
 */
@MyBatisDao
public interface OaPubinfoDao extends CrudDao<OaPubinfo> {

	public OaPubinfo getByProcInsId(String procInsId);
	
	public int updateInsId(OaPubinfo oaPubinfo);
	
	public int updateAdminText(OaPubinfo oaPubinfo);
		
}