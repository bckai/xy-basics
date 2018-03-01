package com.xy.modular.basics.service;

import com.xy.framework.shiro.ShiroUser;
import com.xy.modular.basics.entity.UserAuths;

import java.util.List;

/**
 * 定义shirorealm所需数据的接口
 *
 * @author 
 * @date 2017年06月5日 上午10:23:34
 */
public interface IShiroService {

    /**
     * 根据账号获取登录用户
     *
     * @param account 账号
     */
    UserAuths getUserAuths(String principal);

    /**
     * 根据系统用户获取Shiro的用户
     *
     * @param user 系统用户
     */
    ShiroUser shiroUser(UserAuths userAuths);

    /**
     * 获取权限列表通过角色id
     *
     * @param roleId 角色id
     */
    List<String> findPermissionsByRoleId(Integer roleId);

    /**
     * 根据角色id获取角色名称
     *
     * @param roleId 角色id
     */
    String findRoleNameByRoleId(Integer roleId);

    /**
     * 获取shiro的认证信息
     */
    //SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName);

}
