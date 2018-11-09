package com.fullexception.service;

import java.util.Map;

import com.fullexception.entity.Visitor;

public interface VisitorService {
	
	/**
	 * 游客自动获取我的博客信息，记录登录ip
	 * @return
	 */
	public Visitor tourist(String ip);

	/**
	 * 通过id得到用户
	 * @param authorId
	 * @return
	 */
	public Visitor getVisitorById(Integer authorId);

	/**
	 * 注册时检测用户名重复
	 * @param loginName
	 * @return
	 */
	public Map<String, String> checkLoginName(String loginName);
}
