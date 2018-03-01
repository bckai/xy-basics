package com.xy.framework.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xy.modular.basics.service.IShiroService;

/**
 * shiro的配置类
 * 
 * @author Administrator
 *
 */
@Configuration
public class ShiroConfiguration {
	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	@Resource
	private IShiroService shiroService;

	@Bean(name = "MyRealm")
	public MyRealm getShiroRealm() {
		return new MyRealm();
	}

	@Bean(name = "shiroEhcacheManager")
	public EhCacheManager getEhCacheManager() {
		EhCacheManager em = new EhCacheManager();
		em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return em;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(getShiroRealm());
		dwsm.setCacheManager(getEhCacheManager());
		return dwsm;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(getDefaultWebSecurityManager());
		return new AuthorizationAttributeSourceAdvisor();
	}

	/**
	 * anon任何用户发送的请求都能够访问
	 * 
	 * authc经过认证的请求可访问，否则将会将请求重定向到 ini 配置文件配置的 authc.loginUrl 资源，进行认证操作
	 * 
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		// shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		// shiroFilterFactoryBean.setLoginUrl("/basics/rest/login/timeOut");
		// shiroFilterFactoryBean.setSuccessUrl("/basics/rest/index");
		filterChainDefinitionMap.put("/basics/rest/login/", "anon");
		filterChainDefinitionMap.put("/basics/rest/login", "anon");
		filterChainDefinitionMap.put("/basics/rest/login/timeOut", "anon");
		filterChainDefinitionMap.put("/basics/rest/login/error", "anon");

		filterChainDefinitionMap.put("/basics/rest/login/verification/error", "anon");

		filterChainDefinitionMap.put("/basics/rest/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		//shiroService.findAll();
		// roleService.findAll();
		// ApplicationContext ac2 =
		// WebApplicationContextUtils.getWebApplicationContext(ServletContext sc);
		// SpringUtil.getBean("userService");
		return shiroFilterFactoryBean;
	}
}
