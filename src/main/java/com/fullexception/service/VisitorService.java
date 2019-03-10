package com.fullexception.service;

import java.util.Map;

import com.fullexception.entity.LoginInfo;
import com.fullexception.entity.Visitor;

public interface VisitorService {
	
	/**
	 * 游客自动获取我的博客信息
	 * @return
	 */
	public Visitor tourist();

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
	public Map<String, String> register(String loginName, String loginPassword, String nickName);

	/**
	 * 用户登录
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */
	public Visitor login(String loginName, String loginPassword);

	/**
	 * 添加访问记录
	 * @param visitor
	 */
	public void appendLoginInfo(LoginInfo loginInfo);

	/**
	 * 通过用户名查找
	 * @param userName
	 * @return
	 */
	public Visitor findByUsername(String userName);
}
