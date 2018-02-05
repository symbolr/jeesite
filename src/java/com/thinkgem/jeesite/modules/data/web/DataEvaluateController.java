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
import com.thinkgem.jeesite.modules.data.entity.DataEvaluate;
import com.thinkgem.jeesite.modules.data.service.DataEvaluateService;

/**
 * 客户评价Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataEvaluate")
public class DataEvaluateController extends BaseController {

	@Autowired
	private DataEvaluateService dataEvaluateService;
	
	@ModelAttribute
	public DataEvaluate get(@RequestParam(required=false) String id) {
		DataEvaluate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataEvaluateService.get(id);
		}
		if (entity == null){
			entity = new DataEvaluate();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataEvaluate:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataEvaluate dataEvaluate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataEvaluate> page = dataEvaluateService.findPage(new Page<DataEvaluate>(request, response), dataEvaluate); 
		model.addAttribute("page", page);
		return "modules/data/dataEvaluateList";
	}

	@RequiresPermissions("data:dataEvaluate:view")
	@RequestMapping(value = "form")
	public String form(DataEvaluate dataEvaluate, Model model) {
		model.addAttribute("dataEvaluate", dataEvaluate);
		return "modules/data/dataEvaluateForm";
	}

	@RequiresPermissions("data:dataEvaluate:edit")
	@RequestMapping(value = "save")
	public String save(DataEvaluate dataEvaluate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataEvaluate)){
			return form(dataEvaluate, model);
		}
		dataEvaluateService.save(dataEvaluate);
		addMessage(redirectAttributes, "保存客户评价成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataEvaluate/?repage";
	}
	
	@RequiresPermissions("data:dataEvaluate:edit")
	@RequestMapping(value = "delete")
	public String delete(DataEvaluate dataEvaluate, RedirectAttributes redirectAttributes) {
		dataEvaluateService.delete(dataEvaluate);
		addMessage(redirectAttributes, "删除客户评价成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataEvaluate/?repage";
	}

}