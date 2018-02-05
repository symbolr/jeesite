/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.data.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.data.entity.DataPush;
import com.thinkgem.jeesite.modules.data.service.DataPushService;

/**
 * 公共信息发布表Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataPush")
public class DataPushController extends BaseController {

	@Autowired
	private DataPushService dataPushService;
	
	@ModelAttribute
	public DataPush get(@RequestParam(required=false) String id) {
		DataPush entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataPushService.get(id);
		}
		if (entity == null){
			entity = new DataPush();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataPush:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataPush dataPush, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataPush> page = dataPushService.findPage(new Page<DataPush>(request, response), dataPush); 
		model.addAttribute("page", page);
		return "modules/data/dataPushList";
	}

	@RequiresPermissions("data:dataPush:view")
	@RequestMapping(value = "form")
	public String form(DataPush dataPush, Model model) {
		model.addAttribute("dataPush", dataPush);
		return "modules/data/dataPushForm";
	}

	@RequiresPermissions("data:dataPush:edit")
	@RequestMapping(value = "save")
	public String save(DataPush dataPush, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataPush)){
			return form(dataPush, model);
		}
		dataPushService.save(dataPush);
		addMessage(redirectAttributes, "保存公共信息发布表成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataPush/?repage";
	}
	
	@RequiresPermissions("data:dataPush:edit")
	@RequestMapping(value = "delete")
	public String delete(DataPush dataPush, RedirectAttributes redirectAttributes) {
		dataPushService.delete(dataPush);
		addMessage(redirectAttributes, "删除公共信息发布表成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataPush/?repage";
	}

}