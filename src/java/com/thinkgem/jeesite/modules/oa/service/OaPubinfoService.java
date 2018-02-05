/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.act.utils.ActUtils;
import com.thinkgem.jeesite.modules.oa.dao.OaPubinfoDao;
import com.thinkgem.jeesite.modules.oa.entity.OaPubinfo;

/**
 * 公共信息Service
 * @author 沈波
 * @version 2017-08-03
 */
@Service
@Transactional(readOnly = true)
public class OaPubinfoService extends CrudService<OaPubinfoDao, OaPubinfo> {

	@Autowired
	private ActTaskService actTaskService;
	
	public OaPubinfo getByProcInsId(String procInsId) {
		return dao.getByProcInsId(procInsId);
	}
	
	public Page<OaPubinfo> findPage(Page<OaPubinfo> page, OaPubinfo oaPubinfo) {
		oaPubinfo.setPage(page);
		page.setList(dao.findList(oaPubinfo));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(OaPubinfo oaPubinfo) {
		// 申请发起
		if (StringUtils.isBlank(oaPubinfo.getId())){
			oaPubinfo.preInsert();
			dao.insert(oaPubinfo);
			// 启动流程
			actTaskService.startProcess(ActUtils.PD_PUBINFO[0], ActUtils.PD_PUBINFO[1], oaPubinfo.getId(), oaPubinfo.getContent());
		}
	// 重新编辑申请		
		else{
			oaPubinfo.preUpdate();
			dao.update(oaPubinfo);

			oaPubinfo.getAct().setComment(("yes".equals(oaPubinfo.getAct().getFlag())?"[重申] ":"[销毁] ")+oaPubinfo.getAct().getComment());
			
			// 完成流程任务
			Map<String, Object> vars = Maps.newHashMap();
			vars.put("pass", "yes".equals(oaPubinfo.getAct().getFlag())? "1" : "0");
			actTaskService.complete(oaPubinfo.getAct().getTaskId(), oaPubinfo.getAct().getProcInsId(), oaPubinfo.getAct().getComment(), oaPubinfo.getContent(), vars);
		}
	}
	@Transactional(readOnly = false)
	public void oaPubinfoSave(OaPubinfo oaPubinfo) {
		// 设置意见
		oaPubinfo.getAct().setComment(("yes".equals(oaPubinfo.getAct().getFlag())?"[同意] ":"[驳回] ")+oaPubinfo.getAct().getComment());
		
		oaPubinfo.preUpdate();
		
		// 对不同环节的业务逻辑进行操作
		String taskDefKey = oaPubinfo.getAct().getTaskDefKey();

		// 审核环节
		if ("p1".equals(taskDefKey)){
			oaPubinfo.setAdminText(oaPubinfo.getAct().getComment());
			dao.updateAdminText(oaPubinfo);
		}
		//修改环节
		else if ("p2".equals(taskDefKey)){
		}
		//发布环节
		else if ("p3".equals(taskDefKey)){
		
		}		
		// 未知环节，直接返回	
		else return;
		// 提交流程任务
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pass", "yes".equals(oaPubinfo.getAct().getFlag())? "1" : "0");
		actTaskService.complete(oaPubinfo.getAct().getTaskId(), oaPubinfo.getAct().getProcInsId(), oaPubinfo.getAct().getComment(), vars);
		
	}
	
}