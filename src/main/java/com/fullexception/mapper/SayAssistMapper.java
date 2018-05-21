package com.fullexception.mapper;

import com.fullexception.entity.SayAssist;

public interface SayAssistMapper {
    int deleteByPrimaryKey(Integer sayAssistId);

    int insert(SayAssist record);

    int insertSelective(SayAssist record);

    SayAssist selectByPrimaryKey(Integer sayAssistId);

    int updateByPrimaryKeySelective(SayAssist record);

    int updateByPrimaryKey(SayAssist record);
}