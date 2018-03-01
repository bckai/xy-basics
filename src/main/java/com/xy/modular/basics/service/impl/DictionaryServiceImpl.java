package com.xy.modular.basics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.framework.base.service.BaseServiceImpl;
import com.xy.modular.basics.dao.DictionaryMapper;
import com.xy.modular.basics.entity.Dictionary;
import com.xy.modular.basics.service.IDictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary, String> implements IDictionaryService {

	@Resource
	private DictionaryMapper dictionaryMapper;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		return this.dictionaryMapper;
	}

}
