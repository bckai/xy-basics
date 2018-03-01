package com.xy.modular.basics.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.framework.mreturn.MReturnObject;

@Controller
@RequestMapping("/log")
public class LogController {
	
	static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	public @ResponseBody MReturnObject list() {
		
		return new MReturnObject();
	}

}
