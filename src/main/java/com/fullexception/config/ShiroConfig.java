package com.fullexception.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

public class ShiroConfig {
	@Value("${spring.redis.shiro.host}")
	private String host;
	@Value("${spring.redis.shiro.port}")
	private int port;
	@Value("${spring.redis.shiro.timeout}")
	private int timeout;
	@Value("${spring.redis.shiro.password}")
	private String password;
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		System.out.println("ShiroConfiguration.shiroFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		//过滤器配置顺序不能颠倒
		//配置退出，退出具体实现shiro以实现，配置登出后的url
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/blog/editBlog", "authc");
		filterChainDefinitionMap.put("/blog/addArticleGroup", "authc");
		filterChainDefinitionMap.put("/blog/writeBlog", "authc");
		filterChainDefinitionMap.put("/**", "anon");
		//配置shiro默认登录界面 前后端分离原则，登录界面跳转应该由前端路由器控制，后台仅返回json数据
		shiroFilterFactoryBean.setLoginUrl("/");
		//的录成功跳转的页面
		shiroFilterFactoryBean.setSuccessUrl("/");
		//未授权界面
		//shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 确认散列算法（密码加密算法）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");	//三列算法
		hashedCredentialsMatcher.setHashIterations(32);			//三列次数，2次，md5(md5(password))
		return hashedCredentialsMatcher;
	}
	
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}
	
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		//自定义session管理， 使用redis
		securityManager.setSessionManager(sessionManager());
		// 自定义保存实现 ，使用redis
		securityManager.setCacheManager(cacheManager());
		return securityManager;
	}
	
	/**
	 * 自定义sessionManager
	 * @return
	 */
	@Bean
	public SessionManager sessionManager(){
		MySessionManager mySessionManager = new MySessionManager();
		mySessionManager.setSessionDAO(redisSessionDAO());
		return mySessionManager;
	}
	
	/**
	 * 配置shiro redisManager
	 * 使用shiro-redis开源插件
	 * @return
	 */
	@Bean
	public RedisManager redisManager(){
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setExpire(1800);
		redisManager.setTimeout(timeout);
		redisManager.setPassword(password);
		return redisManager;
	}
	
	/**
	 * cacheManager 缓存redis实现
	 * 
	 * 使用的是shiro-redis开源插件
	 * @return
	 */
	@Bean
	public RedisCacheManager cacheManager(){
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}
	
	@Bean
	public RedisSessionDAO redisSessionDAO(){
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		return redisSessionDAO;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	
	@Bean(name = "exceptionHandler")
	public HandlerExceptionResolver handlerExceptionResolver(){
		return (HandlerExceptionResolver)new MyExceptionhandler();
	}
}
