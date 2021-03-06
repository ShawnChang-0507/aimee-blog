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
	 * 计算访问宗人次
	 * @return
	 */
	int countTheNumberOfVisitors();

	/**
	 * 计算访问总次数
	 * @return
	 */
	int countTheNumberOfVisits();
}