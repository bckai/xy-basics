package com.xy.modular.sys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.framework.mreturn.MReturnObject;
import com.xy.modular.sys.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private IRoleService roleService;

	@RequestMapping("/list")
	private @ResponseBody MReturnObject list() {
		return new MReturnObject(MReturnObject.SUCCESS, roleService.findAll());
	}

}
