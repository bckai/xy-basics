/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package com.xy.framework.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.xy.framework.util.ShiroKitUtils;
import com.xy.modular.basics.entity.UserAuths;
import com.xy.modular.basics.service.IShiroService;
import com.xy.modular.sys.entity.Permission;
import com.xy.modular.sys.entity.Role;

/**
 * http://shiro.apache.org/java-authentication-guide.html
 * 
 * Subject Security specific user 'view' of an application user. It can be a
 * human being, a third-party process, a server connecting to you application
 * application, or even a cron job. Basically, it is anything or anyone
 * communicating with your application.
 * 
 * Principals A subjects identifying attributes. First name, last name, social
 * security number, username
 * 
 * Credentials secret data that are used to verify identities. Passwords,
 * Biometric data, x509 certificates,
 * 
 * Realms Security specific DAO, data access object, software component that
 * talkts to a backend data source. If you have usernames and password in LDAP,
 * then you would have an LDAP Realm that would communicate with LDAP. The idea
 * is that you would use a realm per back-end data source and Shiro would know
 * how to coordinate with these realms together to do what you have to do.
 * 
 * @author BCK
 * 
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private IShiroService shiroService;

	/**
	 * 授权操作
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("--------授-------权------操---------作------------");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// TODO 授-------权------操---------作
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		for (Role role : shiroUser.getRoleList()) {
			info.addRole(role.getId());
			for (Permission p : role.getPermissions()) {
				info.addStringPermission(p.getPermission());
			}
		}
		return info;
	}

	/**
	 * AuthenticationInfo represents a Subject's (aka user's) stored account
	 * information relevant to the authentication/log-in process only.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		/**
		 * Constructor that takes in a single 'primary' principal of the account, its
		 * corresponding hashed credentials, the salt used to hash the credentials, and
		 * the name of the realm to associate with the principals. This is a convenience
		 * constructor and will construct a PrincipalCollection based on the principal
		 * and realmName argument.
		 * 
		 * 
		 * Parameters:
		 * 
		 * principal - the 'primary' principal associated with the specified realm.
		 * hashedCredentials - the hashed credentials that verify the given principal.
		 * credentialsSalt - the salt used when hashing the given hashedCredentials
		 * realmName - the realm from where the principal and credentials were acquired.
		 */

		System.out.println("--------身----份-----验-----证----操----作---------");
		// 获取用户账号
		UserAuths uA = shiroService.getUserAuths(token.getPrincipal().toString());
		if (uA != null) {
			SecurityUtils.getSubject().getSession().setTimeout(1000 * 60 * 30);
			ShiroUser shiroUser = shiroService.shiroUser(uA);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, uA.getCredential(),
					new Md5Hash(uA.getSalt()), super.getName());
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 设置认证加密方式
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
		md5CredentialsMatcher.setHashAlgorithmName(ShiroKitUtils.hashAlgorithmName);
		md5CredentialsMatcher.setHashIterations(ShiroKitUtils.hashIterations);
		super.setCredentialsMatcher(md5CredentialsMatcher);
	}

}
