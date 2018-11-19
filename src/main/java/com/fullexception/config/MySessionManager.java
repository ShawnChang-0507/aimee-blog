package com.fullexception.config;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import com.alibaba.druid.util.StringUtils;

public class MySessionManager extends DefaultWebSessionManager{
	private static final String AUTHORIZATION = "Authorization";
	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
	
	public MySessionManager(){
		super();
	}
	
	
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		//到request的请求头中查找授权
		String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
		if (!StringUtils.isEmpty(id)){
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, true);
			return id;
		}else{
			//没有取到则按照默认规则从cookie取sessionId
			return super.getSessionId(request, response);
		}
	}
}
