/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

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
import com.thinkgem.jeesite.modules.cms.entity.CalEnergyTm;
import com.thinkgem.jeesite.modules.cms.service.CalEnergyTmService;

/**
 * 电量Controller
 * @author 沈波
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/calEnergyTm")
public class CalEnergyTmController extends BaseController {

	@Autowired
	private CalEnergyTmService calEnergyTmService;
	
	@ModelAttribute
	public CalEnergyTm get(@RequestParam(required=false) String id) {
		CalEnergyTm entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = calEnergyTmService.get(id);
		}
		if (entity == null){
			entity = new CalEnergyTm();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:calEnergyTm:view")
	@RequestMapping(value = {"list", ""})
	public String list(CalEnergyTm calEnergyTm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CalEnergyTm> page = calEnergyTmService.findPage(new Page<CalEnergyTm>(request, response), calEnergyTm); 
		model.addAttribute("page", page);
		return "modules/cms/calEnergyTmList";
	}

	@RequiresPermissions("cms:calEnergyTm:view")
	@RequestMapping(value = "form")
	public String form(CalEnergyTm calEnergyTm, Model model) {
		model.addAttribute("calEnergyTm", calEnergyTm);
		return "modules/cms/calEnergyTmForm";
	}

	@RequiresPermissions("cms:calEnergyTm:edit")
	@RequestMapping(value = "save")
	public String save(CalEnergyTm calEnergyTm, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, calEnergyTm)){
			return form(calEnergyTm, model);
		}
		calEnergyTmService.save(calEnergyTm);
		addMessage(redirectAttributes, "保存电量成功");
		return "redirect:"+Global.getAdminPath()+"/cms/calEnergyTm/?repage";
	}
	
	@RequiresPermissions("cms:calEnergyTm:edit")
	@RequestMapping(value = "delete")
	public String delete(CalEnergyTm calEnergyTm, RedirectAttributes redirectAttributes) {
		calEnergyTmService.delete(calEnergyTm);
		addMessage(redirectAttributes, "删除电量成功");
		return "redirect:"+Global.getAdminPath()+"/cms/calEnergyTm/?repage";
	}

}