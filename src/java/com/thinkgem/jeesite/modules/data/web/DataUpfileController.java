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
import com.thinkgem.jeesite.modules.data.entity.DataUpfile;
import com.thinkgem.jeesite.modules.data.service.DataUpfileService;

/**
 * 升级文件Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataUpfile")
public class DataUpfileController extends BaseController {

	@Autowired
	private DataUpfileService dataUpfileService;
	
	@ModelAttribute
	public DataUpfile get(@RequestParam(required=false) String id) {
		DataUpfile entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataUpfileService.get(id);
		}
		if (entity == null){
			entity = new DataUpfile();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataUpfile:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataUpfile dataUpfile, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataUpfile> page = dataUpfileService.findPage(new Page<DataUpfile>(request, response), dataUpfile); 
		model.addAttribute("page", page);
		return "modules/data/dataUpfileList";
	}

	@RequiresPermissions("data:dataUpfile:view")
	@RequestMapping(value = "form")
	public String form(DataUpfile dataUpfile, Model model) {
		model.addAttribute("dataUpfile", dataUpfile);
		return "modules/data/dataUpfileForm";
	}

	@RequiresPermissions("data:dataUpfile:edit")
	@RequestMapping(value = "save")
	public String save(DataUpfile dataUpfile, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataUpfile)){
			return form(dataUpfile, model);
		}
		dataUpfileService.save(dataUpfile);
		addMessage(redirectAttributes, "保存升级文件成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataUpfile/?repage";
	}
	
	@RequiresPermissions("data:dataUpfile:edit")
	@RequestMapping(value = "delete")
	public String delete(DataUpfile dataUpfile, RedirectAttributes redirectAttributes) {
		dataUpfileService.delete(dataUpfile);
		addMessage(redirectAttributes, "删除升级文件成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataUpfile/?repage";
	}

}