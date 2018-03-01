package com.xy.modular.sys.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.framework.base.controller.BaseController;
import com.xy.framework.mreturn.MReturnObject;
import com.xy.framework.mreturn.MReturnUntil;
import com.xy.modular.sys.entity.Module;
import com.xy.modular.sys.service.IModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController extends BaseController {

	static Logger log = LoggerFactory.getLogger(ModuleController.class);

	@Autowired
	private IModuleService moduleService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody MReturnObject List() {
		return new MReturnObject(MReturnObject.SUCCESS, moduleService.findAll());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody MReturnObject save(Module module) {
		try {
			moduleService.validateEntity(module);
			moduleService.save(module);
		} catch (Exception e) {
			log.info("菜单保存失败", e);
			return new MReturnObject(MReturnObject.SUCCESS, MReturnUntil.ERROR_MOUDLE_SAVE);
		}
		return new MReturnObject(MReturnObject.SUCCESS, moduleService.findAll());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody MReturnObject update(Module module) {
		try {
			moduleService.validateEntity(module);
			moduleService.save(module);
		} catch (Exception e) {
			log.info("菜单保存失败", e);
			return new MReturnObject(MReturnObject.SUCCESS, MReturnUntil.ERROR_MOUDLE_SAVE);
		}
		return new MReturnObject(MReturnObject.SUCCESS, moduleService.findAll());
	}
}
