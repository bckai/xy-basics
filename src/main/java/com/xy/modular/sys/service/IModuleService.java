package com.xy.modular.sys.service;

import java.util.List;

import com.xy.framework.base.service.IBaseService;
import com.xy.framework.exceptions.ValidateParamException;
import com.xy.modular.sys.entity.Module;

public interface IModuleService extends IBaseService<Module, String> {

	void validateEntity(Module module) throws ValidateParamException;

	List<Module> List();
}
