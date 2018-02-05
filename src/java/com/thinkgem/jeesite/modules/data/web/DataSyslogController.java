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
import com.thinkgem.jeesite.modules.data.entity.DataSyslog;
import com.thinkgem.jeesite.modules.data.service.DataSyslogService;

/**
 * 日志Controller
 * @author 沈波
 * @version 2017-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/data/dataSyslog")
public class DataSyslogController extends BaseController {

	@Autowired
	private DataSyslogService dataSyslogService;
	
	@ModelAttribute
	public DataSyslog get(@RequestParam(required=false) String id) {
		DataSyslog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dataSyslogService.get(id);
		}
		if (entity == null){
			entity = new DataSyslog();
		}
		return entity;
	}
	
	@RequiresPermissions("data:dataSyslog:view")
	@RequestMapping(value = {"list", ""})
	public String list(DataSyslog dataSyslog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DataSyslog> page = dataSyslogService.findPage(new Page<DataSyslog>(request, response), dataSyslog); 
		model.addAttribute("page", page);
		return "modules/data/dataSyslogList";
	}

	@RequiresPermissions("data:dataSyslog:view")
	@RequestMapping(value = "form")
	public String form(DataSyslog dataSyslog, Model model) {
		model.addAttribute("dataSyslog", dataSyslog);
		return "modules/data/dataSyslogForm";
	}

	@RequiresPermissions("data:dataSyslog:edit")
	@RequestMapping(value = "save")
	public String save(DataSyslog dataSyslog, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dataSyslog)){
			return form(dataSyslog, model);
		}
		dataSyslogService.save(dataSyslog);
		addMessage(redirectAttributes, "保存日志成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataSyslog/?repage";
	}
	
	@RequiresPermissions("data:dataSyslog:edit")
	@RequestMapping(value = "delete")
	public String delete(DataSyslog dataSyslog, RedirectAttributes redirectAttributes) {
		dataSyslogService.delete(dataSyslog);
		addMessage(redirectAttributes, "删除日志成功");
		return "redirect:"+Global.getAdminPath()+"/data/dataSyslog/?repage";
	}

}