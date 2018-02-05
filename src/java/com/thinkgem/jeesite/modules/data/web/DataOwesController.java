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
import com.thinkgem.jeesite.modules.data.entity.DataOwes;
import com.thinkgem.jeesite.modules.data.service.DataOwesService;

/**
 * 欠费详情Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataOwes")
public class DataOwesController extends BaseController {

	@Autowired
	private DataOwesService dataOwesService;
	
	@ModelAttribute
	public DataOwes get(@RequestParam(required=false) String id) {
		DataOwes entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataOwesService.get(id);
		}
		if (entity == null){
			entity = new DataOwes();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataOwes:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataOwes dataOwes, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataOwes> page = dataOwesService.findPage(new Page<DataOwes>(request, response), dataOwes); 
		model.addAttribute("page", page);
		return "modules/data/dataOwesList";
	}

	@RequiresPermissions("data:dataOwes:view")
	@RequestMapping(value = "form")
	public String form(DataOwes dataOwes, Model model) {
		model.addAttribute("dataOwes", dataOwes);
		return "modules/data/dataOwesForm";
	}

	@RequiresPermissions("data:dataOwes:edit")
	@RequestMapping(value = "save")
	public String save(DataOwes dataOwes, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataOwes)){
			return form(dataOwes, model);
		}
		dataOwesService.save(dataOwes);
		addMessage(redirectAttributes, "保存欠费详情成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataOwes/?repage";
	}
	
	@RequiresPermissions("data:dataOwes:edit")
	@RequestMapping(value = "delete")
	public String delete(DataOwes dataOwes, RedirectAttributes redirectAttributes) {
		dataOwesService.delete(dataOwes);
		addMessage(redirectAttributes, "删除欠费详情成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataOwes/?repage";
	}

}