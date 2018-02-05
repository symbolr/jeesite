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
import com.thinkgem.jeesite.modules.data.entity.DataTrans;
import com.thinkgem.jeesite.modules.data.service.DataTransService;

/**
 * 缴费交易Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataTrans")
public class DataTransController extends BaseController {

	@Autowired
	private DataTransService dataTransService;
	
	@ModelAttribute
	public DataTrans get(@RequestParam(required=false) String id) {
		DataTrans entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataTransService.get(id);
		}
		if (entity == null){
			entity = new DataTrans();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataTrans:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataTrans dataTrans, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataTrans> page = dataTransService.findPage(new Page<DataTrans>(request, response), dataTrans); 
		model.addAttribute("page", page);
		return "modules/data/dataTransList";
	}

	@RequiresPermissions("data:dataTrans:view")
	@RequestMapping(value = "form")
	public String form(DataTrans dataTrans, Model model) {
		model.addAttribute("dataTrans", dataTrans);
		return "modules/data/dataTransForm";
	}

	@RequiresPermissions("data:dataTrans:edit")
	@RequestMapping(value = "save")
	public String save(DataTrans dataTrans, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataTrans)){
			return form(dataTrans, model);
		}
		dataTransService.save(dataTrans);
		addMessage(redirectAttributes, "保存缴费交易成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataTrans/?repage";
	}
	
	@RequiresPermissions("data:dataTrans:edit")
	@RequestMapping(value = "delete")
	public String delete(DataTrans dataTrans, RedirectAttributes redirectAttributes) {
		dataTransService.delete(dataTrans);
		addMessage(redirectAttributes, "删除缴费交易成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataTrans/?repage";
	}

}