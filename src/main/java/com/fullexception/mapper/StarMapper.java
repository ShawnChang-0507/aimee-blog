package com.fullexception.mapper;

import com.fullexception.entity.Star;

public interface StarMapper {
    int deleteByPrimaryKey(Integer starId);

    int insert(Star record);

    int insertSelective(Star record);

    Star selectByPrimaryKey(Integer starId);

    int updateByPrimaryKeySelective(Star record);

    int updateByPrimaryKey(Star record);
}