package com.fullexception.mapper;

import com.fullexception.entity.LoginInfo;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Integer loginInfoId);

    int insert(LoginInfo record);

    int insertSelective(LoginInfo record);

    LoginInfo selectByPrimaryKey(Integer loginInfoId);

    int updateByPrimaryKeySelective(LoginInfo record);

    int updateByPrimaryKey(LoginInfo record);
}