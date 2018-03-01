package com.xy.modular.basics.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.framework.base.controller.BaseController;
import com.xy.framework.mreturn.MReturnObject;
import com.xy.modular.basics.entity.User;
import com.xy.modular.basics.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@RequiresPermissions("user:info")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody MReturnObject userList() {
		return new MReturnObject(MReturnObject.SUCCESS, userService.findAll());
	}

	@RequiresPermissions("user:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody MReturnObject save(User user) {
		userService.save(user);
		return new MReturnObject(MReturnObject.SUCCESS, userService.findAll());
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody MReturnObject update(User user) {
		userService.update(user);
		return new MReturnObject(MReturnObject.SUCCESS, userService.findAll());
	}

}
