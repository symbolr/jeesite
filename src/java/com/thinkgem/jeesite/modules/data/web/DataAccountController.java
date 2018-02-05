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
import com.thinkgem.jeesite.modules.data.entity.DataAccount;
import com.thinkgem.jeesite.modules.data.service.DataAccountService;

/**
 * 用户账户Controller
 * @author 沈 波
 * @version 2017-07-21
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataAccount")
public class DataAccountController extends BaseController {

	@Autowired
	private DataAccountService dataAccountService;
	
	@ModelAttribute
	public DataAccount get(@RequestParam(required=false) String id) {
		DataAccount entity = null;
		if (StringUtils.isNotBlank(id)){
			
			entity = dataAccountService.get(id);
		}
		if (entity == null){
			entity = new DataAccount();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataAccount:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataAccount dataAccount, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataAccount> page = dataAccountService.findPage(new Page<DataAccount>(request, response), dataAccount); 
		model.addAttribute("page", page);
		return "modules/data/dataAccountList";
	}

	@RequiresPermissions("data:dataAccount:view")
	@RequestMapping(value = "form")
	public String form(DataAccount dataAccount, Model model) {
		model.addAttribute("dataAccount", dataAccount);
		return "modules/data/dataAccountForm";
	}

	@RequiresPermissions("data:dataAccount:edit")
	@RequestMapping(value = "save")
	public String save(DataAccount dataAccount, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataAccount)){
			return form(dataAccount, model);
		}
		dataAccountService.save(dataAccount);
		addMessage(redirectAttributes, "保存用户账户成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataAccount/?repage";
	}
	
	@RequiresPermissions("data:dataAccount:edit")
	@RequestMapping(value = "delete")
	public String delete(DataAccount dataAccount, RedirectAttributes redirectAttributes) {
		dataAccountService.delete(dataAccount);
		addMessage(redirectAttributes, "删除用户账户成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataAccount/?repage";
	}

}