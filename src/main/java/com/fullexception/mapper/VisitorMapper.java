package com.fullexception.mapper;

import java.util.Map;

import com.fullexception.entity.Visitor;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer visitorId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer visitorId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    /**
     * 通过登录名得到用户
     * @param loginName
     * @return
     */
	Visitor getVisitorByLoginName(String loginName);

	/**
	 * 用户名和密码得到用户
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */
	Visitor getVisitorByNameAndPass(Map<String, String> map);

}