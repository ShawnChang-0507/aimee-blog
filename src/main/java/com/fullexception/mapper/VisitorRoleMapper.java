package com.fullexception.mapper;

import com.fullexception.entity.VisitorRole;

public interface VisitorRoleMapper {
    int deleteByPrimaryKey(Integer visitorRoleId);

    int insert(VisitorRole record);

    int insertSelective(VisitorRole record);

    VisitorRole selectByPrimaryKey(Integer visitorRoleId);

    int updateByPrimaryKeySelective(VisitorRole record);

    int updateByPrimaryKey(VisitorRole record);
}