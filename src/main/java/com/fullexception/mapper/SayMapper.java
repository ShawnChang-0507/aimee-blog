package com.fullexception.mapper;

import com.fullexception.entity.Say;

public interface SayMapper {
    int deleteByPrimaryKey(Integer sayId);

    int insert(Say record);

    int insertSelective(Say record);

    Say selectByPrimaryKey(Integer sayId);

    int updateByPrimaryKeySelective(Say record);

    int updateByPrimaryKey(Say record);
}