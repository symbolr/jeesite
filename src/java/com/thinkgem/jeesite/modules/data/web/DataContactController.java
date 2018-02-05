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
import com.thinkgem.jeesite.modules.data.entity.DataContact;
import com.thinkgem.jeesite.modules.data.service.DataContactService;

/**
 * 短信联系人管理Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataContact")
public class DataContactController extends BaseController {

	@Autowired
	private DataContactService dataContactService;
	
	@ModelAttribute
	public DataContact get(@RequestParam(required=false) String id) {
		DataContact entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataContactService.get(id);
		}
		if (entity == null){
			entity = new DataContact();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataContact:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataContact dataContact, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataContact> page = dataContactService.findPage(new Page<DataContact>(request, response), dataContact); 
		model.addAttribute("page", page);
		return "modules/data/dataContactList";
	}

	@RequiresPermissions("data:dataContact:view")
	@RequestMapping(value = "form")
	public String form(DataContact dataContact, Model model) {
		model.addAttribute("dataContact", dataContact);
		return "modules/data/dataContactForm";
	}

	@RequiresPermissions("data:dataContact:edit")
	@RequestMapping(value = "save")
	public String save(DataContact dataContact, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataContact)){
			return form(dataContact, model);
		}
		dataContactService.save(dataContact);
		addMessage(redirectAttributes, "保存短信联系人成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataContact/?repage";
	}
	
	@RequiresPermissions("data:dataContact:edit")
	@RequestMapping(value = "delete")
	public String delete(DataContact dataContact, RedirectAttributes redirectAttributes) {
		dataContactService.delete(dataContact);
		addMessage(redirectAttributes, "删除短信联系人成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataContact/?repage";
	}

}