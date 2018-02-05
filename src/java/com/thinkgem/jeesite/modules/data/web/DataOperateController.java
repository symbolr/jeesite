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
import com.thinkgem.jeesite.modules.data.entity.DataOperate;
import com.thinkgem.jeesite.modules.data.service.DataOperateService;

/**
 * 操作记录Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataOperate")
public class DataOperateController extends BaseController {

	@Autowired
	private DataOperateService dataOperateService;
	
	@ModelAttribute
	public DataOperate get(@RequestParam(required=false) String id) {
		DataOperate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataOperateService.get(id);
		}
		if (entity == null){
			entity = new DataOperate();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataOperate:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataOperate dataOperate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataOperate> page = dataOperateService.findPage(new Page<DataOperate>(request, response), dataOperate); 
		model.addAttribute("page", page);
		return "modules/data/dataOperateList";
	}

	@RequiresPermissions("data:dataOperate:view")
	@RequestMapping(value = "form")
	public String form(DataOperate dataOperate, Model model) {
		model.addAttribute("dataOperate", dataOperate);
		return "modules/data/dataOperateForm";
	}

	@RequiresPermissions("data:dataOperate:edit")
	@RequestMapping(value = "save")
	public String save(DataOperate dataOperate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataOperate)){
			return form(dataOperate, model);
		}
		dataOperateService.save(dataOperate);
		addMessage(redirectAttributes, "保存操作记录成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataOperate/?repage";
	}
	
	@RequiresPermissions("data:dataOperate:edit")
	@RequestMapping(value = "delete")
	public String delete(DataOperate dataOperate, RedirectAttributes redirectAttributes) {
		dataOperateService.delete(dataOperate);
		addMessage(redirectAttributes, "删除操作记录成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataOperate/?repage";
	}

}