/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.data.entity.DataTrans;

/**
 * 缴费交易DAO接口
 * @author 沈波
 * @version 2017-07-24
 */
@MyBatisDao
public interface DataTransDao extends CrudDao<DataTrans> {
	
}