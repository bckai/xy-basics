package com.xy.modular.basics.dao;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.modular.basics.entity.UserAuths;

public interface UserAuthsMapper extends IBaseDao<UserAuths, java.lang.String>{

	UserAuths getByIdentifier(String identifier);

	UserAuths getByIC(UserAuths userAuths);

}
