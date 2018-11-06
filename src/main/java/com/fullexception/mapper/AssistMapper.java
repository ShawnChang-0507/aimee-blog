package com.fullexception.mapper;

import com.fullexception.entity.Assist;

public interface AssistMapper {
    int deleteByPrimaryKey(Integer assistId);

    int insert(Assist record);

    int insertSelective(Assist record);

    Assist selectByPrimaryKey(Integer assistId);

    int updateByPrimaryKeySelective(Assist record);

    int updateByPrimaryKey(Assist record);
}