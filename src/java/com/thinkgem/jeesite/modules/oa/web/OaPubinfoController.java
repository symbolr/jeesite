/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.web;

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

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.oa.entity.OaPubinfo;
import com.thinkgem.jeesite.modules.oa.service.OaPubinfoService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 公共信息Controller
 * @author 沈波
 * @version 2017-08-03
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaPubinfo")
public class OaPubinfoController extends BaseController {

	@Autowired
	private OaPubinfoService oaPubinfoService;
	
	@ModelAttribute
	public OaPubinfo get(@RequestParam(required=false) String id) {
		OaPubinfo oaPubinfo = null;
		if (StringUtils.isNotBlank(id)){
			oaPubinfo = oaPubinfoService.get(id);
		}
		if (oaPubinfo == null){
			oaPubinfo = new OaPubinfo();
		}
		return oaPubinfo;
	}
	
	@RequiresPermissions("oa:oaPubinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaPubinfo oaPubinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			oaPubinfo.setCreateBy(user);
		}
		Page<OaPubinfo> page = oaPubinfoService.findPage(new Page<OaPubinfo>(request, response), oaPubinfo); 
		model.addAttribute("page", page);
		return "modules/oa/oaPubinfoList";
	}

	@RequiresPermissions("oa:oaPubinfo:view")
	@RequestMapping(value = "form")
	public String form(OaPubinfo oaPubinfo, Model model) {
		String view = "oaPubinfoForm";
		
		// 查看审批申请单
		if (StringUtils.isNotBlank(oaPubinfo.getId())){//.getAct().getProcInsId())){

			// 环节编号
			String taskDefKey = oaPubinfo.getAct().getTaskDefKey();
			
			// 查看工单
			if(oaPubinfo.getAct().isFinishTask()){
				view = "oaPubinfoView";
			}
			// 修改环节
			else if ("p2".equals(taskDefKey)){
				view = "oaPubinfoForm";
			}
			// 审核环节
			else if ("p1".equals(taskDefKey)){
				view = "oaPubinfoPush";
			}
			// 发布环节
			else if ("p3".equals(taskDefKey)){
				view = "oaPubinfoPush";
			}
		}
		model.addAttribute("oaPubinfo", oaPubinfo);
		return "modules/oa/" + view;
	}
	
	@RequiresPermissions("oa:oaPubinfo:edit")
	@RequestMapping(value = "save")
	public String save(OaPubinfo oaPubinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaPubinfo)){
			return form(oaPubinfo, model);
		}
		oaPubinfoService.save(oaPubinfo);
		addMessage(redirectAttributes, "提交审批'" + oaPubinfo.getUser().getName() + "'成功");
		return "redirect:" + adminPath + "/act/task/todo/";
	}
	
	/**
	 * 完成任务
	 */
	@RequiresPermissions("oa:oaPubinfo:edit")
	@RequestMapping(value = "saveOaPubinfo")
	public String saveOaPubinfo(OaPubinfo oaPubinfo, Model model) {
		if (StringUtils.isBlank(oaPubinfo.getAct().getFlag())
				|| StringUtils.isBlank(oaPubinfo.getAct().getComment())){
			addMessage(model, "请填写审核意见。");
			return form(oaPubinfo, model);
		}
		oaPubinfoService.oaPubinfoSave(oaPubinfo);
		return "redirect:" + adminPath + "/act/task/todo/";
	}
	
	@RequiresPermissions("oa:oaPubinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(OaPubinfo oaPubinfo, RedirectAttributes redirectAttributes) {
		oaPubinfoService.delete(oaPubinfo);
		addMessage(redirectAttributes, "删除审批成功");
		return "redirect:"+ adminPath+"/oa/oaPubinfo/?repage";
	}

}