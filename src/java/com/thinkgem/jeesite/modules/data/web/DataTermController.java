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
import com.thinkgem.jeesite.modules.data.entity.DataTerm;
import com.thinkgem.jeesite.modules.data.service.DataTermService;

/**
 * 终端信息Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataTerm")
public class DataTermController extends BaseController {

	@Autowired
	private DataTermService dataTermService;
	
	@ModelAttribute
	public DataTerm get(@RequestParam(required=false) String id) {
		DataTerm entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataTermService.get(id);
		}
		if (entity == null){
			entity = new DataTerm();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataTerm:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataTerm dataTerm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataTerm> page = dataTermService.findPage(new Page<DataTerm>(request, response), dataTerm); 
		model.addAttribute("page", page);
		return "modules/data/dataTermList";
	}

	@RequiresPermissions("data:dataTerm:view")
	@RequestMapping(value = "form")
	public String form(DataTerm dataTerm, Model model) {
		model.addAttribute("dataTerm", dataTerm);
		return "modules/data/dataTermForm";
	}

	@RequiresPermissions("data:dataTerm:edit")
	@RequestMapping(value = "save")
	public String save(DataTerm dataTerm, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataTerm)){
			return form(dataTerm, model);
		}
		dataTermService.save(dataTerm);
		addMessage(redirectAttributes, "保存终端信息成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataTerm/?repage";
	}
	
	@RequiresPermissions("data:dataTerm:edit")
	@RequestMapping(value = "delete")
	public String delete(DataTerm dataTerm, RedirectAttributes redirectAttributes) {
		dataTermService.delete(dataTerm);
		addMessage(redirectAttributes, "删除终端信息成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataTerm/?repage";
	}

}