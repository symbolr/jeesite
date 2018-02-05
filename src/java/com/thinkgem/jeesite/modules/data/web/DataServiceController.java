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
import com.thinkgem.jeesite.modules.data.entity.DataService;
import com.thinkgem.jeesite.modules.data.service.DataServiceService;

/**
 * 服务人员信息Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataService")
public class DataServiceController extends BaseController {

	@Autowired
	private DataServiceService dataServiceService;
	
	@ModelAttribute
	public DataService get(@RequestParam(required=false) String id) {
		DataService entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataServiceService.get(id);
		}
		if (entity == null){
			entity = new DataService();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataService:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataService dataService, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataService> page = dataServiceService.findPage(new Page<DataService>(request, response), dataService); 
		model.addAttribute("page", page);
		return "modules/data/dataServiceList";
	}

	@RequiresPermissions("data:dataService:view")
	@RequestMapping(value = "form")
	public String form(DataService dataService, Model model) {
		model.addAttribute("dataService", dataService);
		return "modules/data/dataServiceForm";
	}

	@RequiresPermissions("data:dataService:edit")
	@RequestMapping(value = "save")
	public String save(DataService dataService, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataService)){
			return form(dataService, model);
		}
		dataServiceService.save(dataService);
		addMessage(redirectAttributes, "保存服务人员信息成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataService/?repage";
	}
	
	@RequiresPermissions("data:dataService:edit")
	@RequestMapping(value = "delete")
	public String delete(DataService dataService, RedirectAttributes redirectAttributes) {
		dataServiceService.delete(dataService);
		addMessage(redirectAttributes, "删除服务人员信息成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataService/?repage";
	}

}