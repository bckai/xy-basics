package com.xy.modular.basics.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.framework.base.controller.BaseController;
import com.xy.framework.mreturn.MReturnObject;
import com.xy.modular.basics.service.IDictionaryService;

@Controller
@RequestMapping("/dic")
public class DictionaryController extends BaseController {

	@Resource
	private IDictionaryService dictionaryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private @ResponseBody MReturnObject list() {
		return new MReturnObject(MReturnObject.SUCCESS, dictionaryService.findAll());
	}

}
