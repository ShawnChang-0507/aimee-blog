package com.fullexception.mapper;

import com.fullexception.entity.LoginInfo;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Integer loginInfoId);

    int insert(LoginInfo record);

    /**
     * 所有登录记录
     * @param ip
     */
    int insertSelective(LoginInfo record);

    LoginInfo selectByPrimaryKey(Integer loginInfoId);

    int updateByPrimaryKeySelective(LoginInfo record);

    int updateByPrimaryKey(LoginInfo record);

	void visitorLogin(String ip);

	/**
	 * 计算当日访问人数（每个ip只记一次）
	 * @return
	 */
	int countTheNumberOfVisitorsToday();

	/**
	 * 计算网站访问总人数（每日重复登录ip只记一次）
	 * @return
	 */
	int countTheTotalNumberOfVisitors();
}