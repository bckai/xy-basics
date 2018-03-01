package com.xy.modular.basics.action;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.framework.JWT;
import com.xy.framework.base.controller.BaseController;
import com.xy.framework.mreturn.MReturnObject;
import com.xy.framework.mreturn.MReturnUntil;
import com.xy.modular.basics.entity.UserAuths;
import com.xy.modular.basics.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "登录相关接口")
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private IUserService userService;

	@ApiOperation(value = "登录", notes = "")
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody MReturnObject login(UserAuths userAuths, Model model) {
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(userAuths.getIdentifier(),
					userAuths.getCredential().toCharArray());
			token.setRememberMe(true);
			subject.login(token);
			return new MReturnObject(MReturnObject.SUCCESS, JWT.sign(userAuths, 30L * 24L * 3600L * 1000L));
		} catch (Exception e) {
			return new MReturnObject(MReturnObject.LOGIN_ERROR, MReturnUntil.ERROR_LOGIN, null);
		}
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public @ResponseBody MReturnObject loginError(Model model) {
		return new MReturnObject(MReturnObject.ERROR, MReturnUntil.WARNING_NOT_LOGIN);
	}

	@RequestMapping(value = "/verification/error", method = RequestMethod.GET)
	public @ResponseBody MReturnObject verification(Model model) {
		return new MReturnObject(MReturnObject.ERROR, MReturnUntil.WARNING_NOT_VERIFICATION);
	}

	@RequestMapping(value = "/login/timeOut", method = RequestMethod.GET)
	public @ResponseBody MReturnObject timeOut(Model model) {
		return new MReturnObject(MReturnObject.TIMEOUT, MReturnUntil.WARNING_NOT_VERIFICATION);
	}
}
