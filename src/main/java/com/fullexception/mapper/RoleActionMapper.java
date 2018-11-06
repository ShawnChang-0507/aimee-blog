package com.fullexception.mapper;

import com.fullexception.entity.RoleAction;

public interface RoleActionMapper {
    int deleteByPrimaryKey(Integer roleActionId);

    int insert(RoleAction record);

    int insertSelective(RoleAction record);

    RoleAction selectByPrimaryKey(Integer roleActionId);

    int updateByPrimaryKeySelective(RoleAction record);

    int updateByPrimaryKey(RoleAction record);
}