package com.xy.modular.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.framework.base.service.BaseServiceImpl;
import com.xy.framework.exceptions.ValidateParamException;
import com.xy.modular.sys.dao.ModuleMapper;
import com.xy.modular.sys.entity.Module;
import com.xy.modular.sys.service.IModuleService;

@Service("moduleService")
public class ModuleServiceImpl extends BaseServiceImpl<Module, String> implements IModuleService {

	@Resource
	private ModuleMapper moudleMapper;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		return this.moudleMapper;
	}

	@Override
	public List<Module> List() {
		return null;
		//return moudleMapper.List();
	}

	@Override
	public void validateEntity(Module module) throws ValidateParamException {
		
	}
}
