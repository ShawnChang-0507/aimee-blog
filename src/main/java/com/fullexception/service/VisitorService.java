package com.fullexception.service;

import com.fullexception.entity.Visitor;

public interface VisitorService {
	
	/**
	 * 游客自动获取我的博客信息，记录登录ip
	 * @return
	 */
	public Visitor tourist(String ip);
}
